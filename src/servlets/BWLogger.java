package servlets;
import java.io.*;
import java.lang.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


public class BWLogger {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		
	public BWLogger(PrintStream so, String logToFile) {
		PrintStream OP2File=null;
		PrintStream err2File=null;
		
		PrintStream stdOutwDateTime = new PrintStream(so) {
			
			@Override
			public void println(String x) {
				Date date = new Date();
				Timestamp timestamp = new Timestamp(date.getTime());
				
				super.println(sdf.format(timestamp)+ " " + x);
				}
			public void println(int x) {
				Date date = new Date();
				Timestamp timestamp = new Timestamp(date.getTime());
				
				super.println(sdf.format(timestamp)+ " " + x);
				}
			};
			System.setOut(stdOutwDateTime);
		
		if (logToFile.equals("1")) {
			try {
				String cDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				String lFname = "logFile" + cDate + ".txt";				
				
				OP2File = new PrintStream(new FileOutputStream(lFname)){
					@Override
					public void println(String x) {
						Date date = new Date();
						Timestamp timestamp = new Timestamp(date.getTime());
						
						super.println(sdf.format(timestamp)+ " " + x);
						}
					public void println(int x) {
						Date date = new Date();
						Timestamp timestamp = new Timestamp(date.getTime());
						
						super.println(sdf.format(timestamp)+ " " + x);
						}
					};
				
				String eFname = "errorFile" + cDate + ".txt";
				err2File = new PrintStream(new FileOutputStream(eFname)){
					@Override
					public void println(String x) {
						Date date = new Date();
						Timestamp timestamp = new Timestamp(date.getTime());
						
						super.println(sdf.format(timestamp)+ " " + x);
						}
					public void println(int x) {
						Date date = new Date();
						Timestamp timestamp = new Timestamp(date.getTime());
						
						super.println(sdf.format(timestamp)+ " " + x);
						}
					};
				System.setOut(OP2File);
				System.setErr(err2File);
				System.out.println("Logging will be directed to a file = " + lFname + " .. " + err2File);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Standard logging will be used");
		}
	}
}