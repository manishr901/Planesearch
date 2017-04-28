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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@WebServlet("/flight")
public class Flight extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7302245909633673742L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject jsonResponse = new JsonObject();
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		PrintWriter out = resp.getWriter();
		/* System.out.println(from + to); */

		Connection con = DBUtils.getConnection();
		try {
			Statement stmnt = con.createStatement();
			Statement stmnt1 = con.createStatement();
			ResultSet rst = stmnt.executeQuery("select plane, time from flight where city='" + from + "'");

			ResultSet rst1 = stmnt1.executeQuery("select plane, time from flight1 where city='" + to + "'");

			JsonArray data_plane = new JsonArray();
			JsonArray data_from_time = new JsonArray();
			JsonArray data_to_time = new JsonArray();
			while (rst1.next() && rst.next()) {

				if (rst.getString("plane").equals(rst1.getString("plane"))) {
					data_plane.add(new JsonPrimitive(rst.getString("plane")));
				}

				data_from_time.add(new JsonPrimitive(rst.getString("time")));
				data_to_time.add(new JsonPrimitive(rst1.getString("time")));

			}
			jsonResponse.add("plane", data_plane);
			jsonResponse.add("from", data_from_time);
			jsonResponse.add("to", data_to_time);

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");

			out.print(jsonResponse);
			out.flush();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
