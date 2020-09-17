package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
		static Connection con;
		static Connection getConnection()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","mypass");
				System.out.println("Database Connected");
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(ClassNotFoundException cn)
			{
				System.out.println(cn);
			}
			return con;
		}
	}


