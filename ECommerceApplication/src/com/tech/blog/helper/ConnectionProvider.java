package com.tech.blog.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
            	
            	//Read db.properties
				
				File f=new File("D://Eclipse//ECommerceApplication//src//db.properties");
				 // 	File f=new File("D://Eclipse//ECommerceApplication//db.properties");
            	FileInputStream fis=new FileInputStream(f);
				 
                Properties properties=new Properties();
                properties.load(fis);
                
                //reading data from properties file
                
                String driver=properties.getProperty("driver");
                String url=properties.getProperty("url");
                String username=properties.getProperty("username");
                String password=properties.getProperty("password");
                
                
                
                //Register driver
                Class.forName(driver);
                
                //create a connection..
                
                con = DriverManager.
                        getConnection(url,username,password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}
