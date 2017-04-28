package com.cgi.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgi.learning.common.DBUtils;

@WebServlet("/Registratin")
public class RegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CountryServlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String contact = req.getParameter("contact");
		String bloodgroup = req.getParameter("blood_group");
		String street = req.getParameter("street");
		String area = req.getParameter("area");
		String city = req.getParameter("city");
		String district = req.getParameter("dist");

		/* System.out.println(contactid); */
		Connection con = DBUtils.getConnection();
		try {
			PreparedStatement stmnt = con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?,?)");
			stmnt.setString(1, name);
			stmnt.setString(2, password);
			stmnt.setString(3, area);
			stmnt.setString(4, email);

			stmnt.setString(5, city);
			stmnt.setString(6, street);
			stmnt.setString(7, bloodgroup);
			stmnt.setString(8, district);
			stmnt.setString(9, contact);
			int i = stmnt.executeUpdate();
			out.print("Successfully Registered");
			log.log(Level.INFO, "no of inserted row - " + i);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
