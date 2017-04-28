package com.cgi.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import com.cgi.learning.common.DBUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7917127991443517344L;

	private static final Logger log = Logger.getLogger(CountryServlet.class.getName());

	// private static final String QUERY_FETCH_STATES = "select cityname from
	// cities where countryid=''{0}''";

	public String convert(ResultSet rs) throws SQLException {
		ObjectNode node = new ObjectMapper().createObjectNode();
		while (rs.next()) {
			node.put("countryname", rs.getString(1));
		}
		return node.toString();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject jsonResponse = new JsonObject();
		PrintWriter out = resp.getWriter();
		String country = req.getParameter("name");

		// will be used after settling all
		/*
		 * log.log(Level.INFO, "Fetching states for country - " + country);
		 * List<String> array = DBUtils.fetchData(r -> { List<String> states =
		 * new ArrayList<>(); try { while (r.next()) {
		 * states.add(r.getString(1)); } } catch (Exception e) {
		 * e.printStackTrace(); } return states; }, QUERY_FETCH_STATES, new
		 * Object[] { country });
		 */

		Connection con = DBUtils.getConnection();
		Statement stmnt = null;
		try {
			stmnt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rst = null;
		try {
			rst = stmnt.executeQuery("select cityname from cities where countryid ='" + country + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonArray data = new JsonArray();

		try {
			while (rst.next()) {
				try {
					data.add(new JsonPrimitive(rst.getString(1)));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jsonResponse.add("City", data);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		out.print(jsonResponse);
		out.flush();
/*
		log.log(Level.INFO, "States returned - " + jsonResponse);*/
		// resp.getWriter().print(array);

	}
}
