package com.cgi.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgi.learning.common.DBUtils;
import com.cgi.learning.sendmail.SendMailTLS;

@WebServlet("/forgetpassword")
public class Forgetpassword extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		Connection con = DBUtils.getConnection();
		try {
			Statement stmnt=con.createStatement();
			ResultSet rst=stmnt.executeQuery("select * from registration where email='"+email+"'");
		
			int a=0;
			while(rst.next())
			{
				
				
				
				
			 a=10;
			
			}
			out.println(a);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
