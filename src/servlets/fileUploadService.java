package servlets;

/*
 * Sarang 03/03/06
 * Upload Documents from Excel
 *
 */

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.boardwalk.database.*;
import com.boardwalk.table.*;
import com.boardwalk.user.UserManager;
import com.boardwalk.exception.*;
import com.boardwalk.distribution.*;

import java.sql.*;                  // JDBC package
import javax.sql.*;                 // extended JDBC packa

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;


public class fileUploadService extends HttpServlet
implements SingleThreadModel
{

    public final static String Seperator = new Character((char)1).toString();
    public final static String ContentDelimeter = new Character((char)2).toString();
    StringTokenizer st;
    int userId;
    String userName;
    String userPassword;
    int nhId;
    int  memberId;
    String nhName;
    int tid;
    String m_ViewPreference;
    String m_SortPreference;
    int rowCount;
    int columnCount;
    int transactionId;
    //xlError xle;

    public void service (HttpServletRequest req,
                            HttpServletResponse res)
    throws ServletException, IOException
    {
        res.setContentType ( "text/html");
        ServletOutputStream servletOut = res.getOutputStream ();
		BufferedOutputStream fOut = null;
		InputStream in = null;
		long fileSize = 0;
		String fileName = null;
		String contentType = "application/octet-stream";
		String ext = "";
		System.out.println("Commiting Document ");
		boolean isMultipart = FileUpload.isMultipartContent(req);
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();
		String action = "";
		String templateName = "";
		int templateMajorVersion = 0;
		int templateMinorVersion = 0;

		action = (String)req.getParameter("action");
		if (action != null && action.equals("publishTemplate")) // publish template
		{
			System.out.println("Publishing template");
			templateName = (String)req.getParameter("templateName");
			System.out.println("templateName = " + templateName);
			templateMajorVersion = Integer.parseInt((String)req.getParameter("templateMajorVersion"));
			System.out.println("templateMajorVersion = " + templateMajorVersion);
			templateMinorVersion = Integer.parseInt(req.getParameter("templateMinorVersion"));
			System.out.println("templateMinorVersion = " + templateMinorVersion);
		}
		else
		{
			System.out.println("Inserting a document");
		}

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		try
		{
			// Parse the request
			List /* FileItem */ items = upload.parseRequest(req);
			// Process the uploaded items
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();

					System.out.println("FileUpload: name = "+ name + " value = " + value);

				} else {
					fileName = item.getName();
					fileSize = item.getSize();
					contentType = getServletContext().getMimeType(fileName);
					System.out.println("Uploading file = " + fileName);

					if (contentType != null)
					{
						System.out.println("content-type = " + contentType);
					}
					else
					{
						contentType =	"application/octet-stream";
						System.out.println("content-type = null");
					}
					int dotPlace = fileName.lastIndexOf ( '.' );

					if ( dotPlace >= 0 )
					{
						// possibly empty
						ext = fileName.substring( dotPlace + 1 );
					}
					else
					{
						ext = "";
					}
					in = item.getInputStream();
				}
			}
		}
		catch (FileUploadException fue)
		{
			fue.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement ps = null;
		TransactionManager tm = null;
		try
		{
			DatabaseLoader databaseloader = new DatabaseLoader(new Properties());
			connection = databaseloader.getConnection();
			int tid = -1;
			if (action != null && action.equals("publishTemplate"))
			{
				String msTemplatePath = null;
				//String sourcexml = databaseloader.getSourceDistributionXML();
				//String targetxml = databaseloader.getTargetDistributionXML();
				//ArrayList DistributionObjs = DistributionList.getObjects(sourcexml, targetxml);
				//boolean lbFound = false;
				//for(int liDbCount = 0 ; liDbCount < DistributionObjs.size() ; liDbCount++)
				//{
				//    Distribution DistributionObj = (Distribution)DistributionObjs.get(liDbCount);
				//    ArrayList laTemplates = DistributionObj.getTemplates();
				//    for(int liTempCount = 0 ; liTempCount <  laTemplates.size() ; liTempCount++)
				//    {
				//        DistributionTemplate DistributionTemplateObj = (DistributionTemplate)laTemplates.get(liTempCount);
				//        if(templateName.equals(DistributionTemplateObj.getmsTemplateName()))
				//        {
				//            msTemplatePath	= DistributionTemplateObj.getmsTemplateLocation();
				//            lbFound = true;
				//            break;
				//        }
				//    }
				//    if(lbFound)
				//        break;
				//}
				msTemplatePath = getServletContext().getRealPath("/templates")+ "//" +templateName + ".xlsb";
				//if (lbFound)
				//{
					System.out.println("Template location = " + msTemplatePath);
					System.out.println("Saving template");

					fOut = new BufferedOutputStream(new FileOutputStream(msTemplatePath));
					byte[] buffer = new byte[32*1024];
					int bytesRead = 0;
					while ((bytesRead = in.read(buffer)) != -1)
					{
						fOut.write(buffer, 0, bytesRead);
					}
					fOut.flush();
					fOut.close();
					fOut = null;
					System.out.println("Done saving the template");

					String query = "DELETE FROM BW_TEMPLATE_VERSION WHERE NAME = ? ; INSERT INTO BW_TEMPLATE_VERSION VALUES (?,?,?)";
					ps = connection.prepareStatement (query);
					ps.setString(1, templateName);
					ps.setString(2, templateName);
					ps.setInt(3, templateMajorVersion);
					ps.setInt(4, templateMinorVersion);
					ps.execute();
					ps.close();
					ps = null;

					String responseToUpdate = "<html><body>Success</body></html>" + xlService.ContentDelimeter;
					res.setContentLength(responseToUpdate.length());
					servletOut.print(responseToUpdate);
					servletOut.close();
				//}
			}
			else // create blob
			{
				System.out.print("Creating a blob");
				//tm = new TransactionManager(connection, userId);
				//int tid = tm.startTransaction();
				int blobId = BlobManager.addDocumentToCell(
								connection,
								tid,
								in,
								(int)fileSize,
								fileName,
								ext,
								contentType,
								null,
								-1,
								null,
								null
								 );
				//tm.commitTransaction();
				in.close();

				String responseToUpdate = "<html><body>Success</body></html>" + xlService.ContentDelimeter + blobId;
				res.setContentLength(responseToUpdate.length());
				servletOut.print(responseToUpdate);
				servletOut.close();
			}
		}
        catch ( Exception e )
        {
           e.printStackTrace();
           /*
           try
           {
                tm.rollbackTransaction();
           }
           catch( SQLException sqlfatal )
           {
               sqlfatal.printStackTrace();
           }*/
        }
        finally
        {
            try
            {
				if ( connection != null )
					connection.close();
				if (ps != null)
					ps.close();
				if (in != null)
					in.close();
				if (fOut != null)
					fOut.close();
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        }
    }


    public boolean  loginUser ()
    {

        String wrkstr;
        wrkstr = st.nextToken (Seperator);
        userId = Integer.parseInt(wrkstr);

        wrkstr = st.nextToken (Seperator);
        userName = wrkstr;

        wrkstr = st.nextToken (Seperator);
        userPassword = wrkstr;

        wrkstr = st.nextToken (Seperator);
        memberId = Integer.parseInt(wrkstr);

        wrkstr = st.nextToken (Seperator);
        nhId = Integer.parseInt(wrkstr);

        wrkstr = st.nextToken (Seperator);
        nhName =wrkstr;

        Connection connection = null;
        try
        {
            DatabaseLoader databaseloader = new DatabaseLoader(new Properties());
            connection = databaseloader.getConnection();

            if (  userName == null  || userName == ""  || userPassword ==null || userPassword == "" )
            {
                return false;
            }
            else
            {

                int db_userId = UserManager.authenticateUser(connection, userName,userPassword, false);

                if ( userId != -1 && userId == db_userId )
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
        catch ( Exception e )
        {
           e.printStackTrace();
           return false;
        }
        finally
        {
          try
          {
            connection.close();
          }
          catch ( SQLException sql )
          {
            sql.printStackTrace();
            return false;
          }
            // System.out.println("End loginUser : " + getElapsedTime());
        }
    }
}
