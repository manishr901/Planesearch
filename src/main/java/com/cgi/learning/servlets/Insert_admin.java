package com.cgi.learning.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgi.learning.common.DBUtils;

@WebServlet("/insert_admin")
public class Insert_admin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1291360650151941667L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String city = req.getParameter("city");
		String plane = req.getParameter("plane");
		String time = req.getParameter("time");

		Connection con = DBUtils.getConnection();
		try {
			PreparedStatement stmnt = con.prepareStatement("insert into flight values(?,?,?)");

			stmnt.setString(1, city);
			stmnt.setString(2, plane);
			stmnt.setString(3, time);
			int i = stmnt.executeUpdate();
			System.out.println(i);
			req.setAttribute("result", i);
			req.getRequestDispatcher("insert_admin.jsp").forward(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
