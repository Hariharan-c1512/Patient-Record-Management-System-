
package com.wipro.patient.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection() 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="SYSTEM";
			String pass="root";
			Connection connection=DriverManager.getConnection(url,user,pass);
			return connection;
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}
}
