// Decompiled by Decafe PRO - Java Decompiler
// Classes: 1   Methods: 7   Fields: 1

package com.boardwalk.database;
import java.io.PrintStream;
import java.sql.*;
import java.util.Properties;
import java.io.*;
import javax.sql.DataSource;
import java.lang.Runtime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.text.SimpleDateFormat;



public class DatabaseLoader
{

    public static boolean  databaseInit = false;
    public static String databasetype = null;
    public static QueryLoader queryLoader = null;
    public static String databasename = null;
	public static String InstanceName = null;
	public static String user = null;
	public static String password = null;
	public static String server = null;
	public static String port = null;
	public static String sqlpath = null;
	public static String sourcexml = null;
	public static String targetxml = null;
    public static String jdbcConnectionString = null;
	public static String databaseStatus = null;
	public static javax.servlet.ServletContext servletcontext = null;
    public static String templatedir = null;

    // Boardwalk defaults
    public static boolean default_column_access = false;
    public static int default_column_access_creator = 2;
	public static int default_column_access_private = 2;
	public static int default_column_access_domain = 2;
	public static int default_column_access_children = 2;
	public static int default_column_access_custom = 2;


   public static void initDatabase(Properties properties)
   {
	   try
	   {
			System.out.println("Inside DatabaseLoader.initDatabase");
			if ( ! databaseInit && properties.size() > 0 )
			{
				databaseInit = true;
				// DriverManager.setLogWriter(null);

				databasename = properties.getProperty("databasename");
				InstanceName = properties.getProperty("InstanceName");
				user = properties.getProperty("user");
				password = properties.getProperty("password");
				server = properties.getProperty("server");
				port = properties.getProperty("port");
				databasetype = properties.getProperty("databasetype");
				sqlpath = properties.getProperty("sqlpath");
				templatedir = properties.getProperty("templatedir");
				sourcexml = properties.getProperty("sourcexml");
				targetxml = properties.getProperty("targetxml");

				//DriverManager.registerDriver(new com.microsoft.jdbc.sqlserver.SQLServerDriver());
				//jdbcConnectionString = "jdbc:microsoft:sqlserver://"+server+":"+port+";DatabaseName="+databasename+";sendStringParametersAsUnicode=true"+ ";user="+user+";password="+password;

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
				//jdbcConnectionString = "jdbc:jtds:sqlserver://" + server + ":" + port;
				
				
				
				/*SQLAZURECONNSTR_boardwalkclient_RIC=jdbc:sqlserver://bw-eny-sb.database.windows.net:1433;DatabaseName=BW-ENY-RIC;sendStringParametersAsUnicode=true;user=bwappuser;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;password=Boardwalk@1032*/


/*				//Code for SSL - START
				//With JTDS
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
				jdbcConnectionString = "jdbc:jtds:sqlserver://" + server + ":" + port;
				jdbcConnectionString = jdbcConnectionString + ";DatabaseName=" + databasename + ";encrypt=True;user=" + user + ";password=" + password;
				jdbcConnectionString = jdbcConnectionString + ";ssl=require";

				//With JDBS
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				jdbcConnectionString = "jdbc:sqlserver://" + server + ":" + port;
				jdbcConnectionString = jdbcConnectionString + ";DatabaseName=" + databasename + ";encrypt=True;user=" + user + ";password=" + password;
				//Code for SSL - END
*/

				if (!((InstanceName.trim().equals("")) || InstanceName.trim().equalsIgnoreCase("default")))
					//jdbcConnectionString = jdbcConnectionString + ";instance=" + InstanceName;
				
				/*jdbcConnectionString = jdbcConnectionString + ";DatabaseName="+databasename+";sendStringParametersAsUnicode=true"+ ";user="+user+";password="+password;
				jdbcConnectionString += ";encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30";*/
				
				jdbcConnectionString ="jdbc:sqlserver://"+server+":" +port+ ";DatabaseName="+databasename+";sendStringParametersAsUnicode=true;user="+user+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;password="+password;
				jdbcConnectionString = "jdbc:sqlserver://marsanalyticsdevsqlsrv.database.windows.net:1433;DatabaseName=aohusmwtpodevdevsqldb1;sendStringParametersAsUnicode=true;user=BWUSER;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;password=#@BOARDWALK_65432m";
				
				
				System.out.println("jdbcConnectionString NEW--------------> "+jdbcConnectionString);
				
				//System.out.println("jdbcConnectionString --------------> "+jdbcConnectionString);
				queryLoader = new  QueryLoader(properties);

				//jdbcConnectionString = "jdbc:microsoft:sqlserver://"+databasehostname+":"+ portnumber+";SelectMethod=cursor;DatabaseName="+databasename+";user="+user+";password="+ password;
				//jdbcConnectionString = "jdbc:odbc:"+ databasename+";user="+user+";password="+password+";EXEC="+"T"+";XSM="+"SA"+";DBQ="+"BW";
			}
	   }
	   catch(Exception exception)
	   {
		   exception.printStackTrace();
	   }
    }

    public DatabaseLoader(Properties properties)
    {
		System.out.println("DatabaseLoader Called");

		//System.out.println("jdbcConnectionString g2 " + jdbcConnectionString);
        if(! databaseInit)
            initDatabase(properties);
    }

	public DatabaseLoader(Properties properties, javax.servlet.ServletContext sc)
	{
		System.out.println("DatabaseLoader Called");

		if(! databaseInit)
		{
			servletcontext = sc;
			initDatabase(properties);
		}
    }

    public static PreparedStatement getPreparedStatementFromPreLoadedQueries(String queryName, Connection connection)
    throws SQLException
    {
		String query = queryLoader.getQueryString(queryName);
		PreparedStatement preparedstatement = connection.prepareStatement(query);
		return preparedstatement;
	}

	public static String getDatabaseType()
    {
		return databasetype;
	}

	public static String getSQLPath()
	{
		return sqlpath;
	}

	public static String getSourceDistributionXML()
	{
		return sourcexml;
	}

	public static String getTargetDistributionXML()
	{
		return targetxml;
	}

    public Connection getConnection()
        throws SQLException
    {
		Connection conn = null;

		try
		{
   		  	conn =  DriverManager.getConnection(jdbcConnectionString);
   		  	//conn.setAutoCommit(true);

			//Added by Lakshman on 201712014 to set ARITHABORT = ON from Client - START
			try
			{
				System.out.println("Database Connection Established.");

				try (Statement stmt = conn.createStatement())
				{
					try (ResultSet rs = stmt.executeQuery("SELECT CONVERT(INT, SESSIONPROPERTY('ARITHABORT'))"))
					{
						rs.next();
						System.out.println(String.format("SESSIONPROPERTY('ARITHABORT') is %d",rs.getInt(1)));
						
						if(rs.getInt(1) == 0)
						{
							String sql = "SET ARITHABORT ON";
							System.out.println(sql);
							stmt.execute(sql);
						}
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace(System.out);
			}
			//Added by Lakshman on 201712014 to set ARITHABORT = ON from Client - END
	  	}
	  	catch( SQLException sqe )
	  	{
			DatabaseLoader.databaseStatus="There is a Database connection problem. Either the database is down or the connection parameters are wrong.";
			throw sqe;
		}
	     DatabaseLoader.databaseStatus = "";
		 return conn;
    }

    public static void main(String args[])
        throws Exception
    {
        DatabaseLoader databaseloader = new DatabaseLoader(new Properties());
        Connection conn = databaseloader.getConnection();
    }
}
