package com.cgi.learning.servlets;

import java.io.IOException;
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

@WebServlet("/forgetpasswordemail")
public class Forgetpasswordemail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		Connection con = DBUtils.getConnection();
		
		Statement stmnt;
		
		try {
			stmnt = con.createStatement();
			ResultSet rst = stmnt.executeQuery("select * from registration where email='" + email + "'");
			while (rst.next()) {
				
				SendMailTLS sendmail = new SendMailTLS();
				sendmail.sendMail(email, rst.getString("password"),rst.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
