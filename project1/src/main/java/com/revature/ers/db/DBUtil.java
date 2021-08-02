package com.revature.ers.db;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {

	public static  Connection getConnection()  throws Exception{
		
		FileInputStream fileStream = new FileInputStream("C:\\Users\\RagulR\\git\\project1\\project1\\src\\main\\resources\\jdbc.properties"); //io
		Properties properties = new Properties(); //resource bundle 
		properties.load(fileStream);
		String url = properties.getProperty("url");	
		String id = properties.getProperty("id"); 
		String pwd = properties.getProperty("pwd"); 
	     Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con = DriverManager.getConnection(url,id,pwd); 
		  return con;
	}
}

