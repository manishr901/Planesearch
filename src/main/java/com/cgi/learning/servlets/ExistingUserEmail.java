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

@WebServlet("/ExistingUserEmail")
public class ExistingUserEmail extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5717035830443623440L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");

		Connection con = DBUtils.getConnection();
		try {
			Statement stmnt = con.createStatement();
			ResultSet rst = stmnt.executeQuery("select email from registration where email='" + email + "'");
			int i = 0;
			while (rst.next()) {
				i++;
			}
			if (i > 0) {

				int a = 12;
				out.println(a);
			} else {
				int a = 13;
				out.println(a);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
