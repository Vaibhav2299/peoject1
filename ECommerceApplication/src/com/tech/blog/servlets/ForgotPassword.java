package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.helper.ConnectionProvider;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Connection con=ConnectionProvider.getConnection();
			String email=request.getParameter("email");
			
			String password=request.getParameter("cpassword");
			PreparedStatement ps=con.prepareStatement("update user set password=? where email=?");
			ps.setString(2,email);
			ps.setString(1, password);
		
			int i=ps.executeUpdate();
			if(i>0) {
				PrintWriter out=response.getWriter();
				
				response.sendRedirect("login_page.jsp");
			} else {
				response.sendRedirect("error_page.jsp");
				} 
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
