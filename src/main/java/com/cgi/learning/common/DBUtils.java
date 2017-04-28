package com.cgi.learning.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

public class DBUtils {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(AppProperties.get(AppConstants.DRIVER));
			conn = DriverManager.getConnection(AppProperties.get(AppConstants.DB_URL),
					AppProperties.get(AppConstants.USER_NAME), AppProperties.get(AppConstants.PWD));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static <T> T fetchData(ResultsCallBack<T> resultCallBack, String query, Object[] args) {
		// Create a connection, fetch results then return the results
		try (Connection conn = getConnection();) {
			query = MessageFormat.format(query, args);
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			return resultCallBack.readResult(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
