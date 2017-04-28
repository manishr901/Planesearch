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

@WebServlet("/schedule")
public class Schedule extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5186226502509410891L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject jsonResponse = new JsonObject();
		PrintWriter out = resp.getWriter();
		String plane = req.getParameter("plane");
		Connection con = DBUtils.getConnection();
		try {
			Statement stmnt = con.createStatement();
			ResultSet rst = stmnt.executeQuery("select city,time from flight where plane='" + plane + "'");
			JsonArray data_Schdeule_city = new JsonArray();
			JsonArray data_Schdeule_time = new JsonArray();
			while (rst.next()) {
				data_Schdeule_city.add(new JsonPrimitive(rst.getString("city")));
				data_Schdeule_time.add(new JsonPrimitive(rst.getString("time")));
			}

			jsonResponse.add("city", data_Schdeule_city);
			jsonResponse.add("time", data_Schdeule_time);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
		
			out.print(jsonResponse);
			out.flush();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
