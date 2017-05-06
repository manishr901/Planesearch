package com.cgi.learning.servlets;

import java.io.IOException;

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
import javax.servlet.http.HttpSession;

import com.cgi.learning.common.DBUtils;
import com.cgi.learning.common.UserTracker;
import com.cgi.learning.common.UserTracker.UserTrackerInstance;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {

	private static final long serialVersionUID = -570677565107164074L;
	private static final Logger log = Logger.getLogger(Loginservlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");

		Connection con = DBUtils.getConnection();
		
		try {
			System.out.println("sdf");
			
			if (email.equals("admin@admin.com") && password.equals("admin")) {
				HttpSession session = req.getSession();
				session.setAttribute("userName", email);
				resp.sendRedirect("home_admin.jsp");
			} else {
				Statement stmnt = con.createStatement();
				ResultSet rst = stmnt.executeQuery(
						"select * from registration where email='" + email + "'and password='" + password + "'");

				if (rst.next()) {

					HttpSession session = req.getSession();
					session.setAttribute("userName", email);
					UserTracker tracker = UserTrackerInstance.INSTANCE.getInstance();
					tracker.addUser(email);
					log.log(Level.INFO, "session initialized - " + (null == session));
					log.log(Level.INFO,
							"for user-" + rst.getString("name") + " session with session id" + session.getId());

					req.setAttribute("name", rst.getString("name"));
					req.setAttribute("contact", rst.getString("contact"));
					req.setAttribute("email", rst.getString("email"));
					req.setAttribute("city", rst.getString("city"));
					req.getRequestDispatcher("home.jsp").forward(req, resp);

					log.log(Level.INFO, "no of  total users  - " + tracker.getTotalUsers());
					log.log(Level.INFO, "no of current users  - " + tracker.getCurrentUsers());

				} else {

					resp.sendRedirect("./login?error=403&&userName=" + email);
					// req.getRequestDispatcher("Login.jsp?wrong=1").forward(req,
					// resp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
