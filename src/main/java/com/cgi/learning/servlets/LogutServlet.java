package com.cgi.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final Logger log = Logger.getLogger(LogutServlet.class.getName());
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		session.invalidate();
		log.log(Level.INFO, "Session destroyed for user  - " + req.getParameter("name"));
		out.println("<html><head>");
		out.print("You are successfully logged out!");
		out.println("<h3><a href=\"Login.jsp\">Login again</a></h3>");
		out.println("</head></html>");
		req.getRequestDispatcher("Registration.html");
	}
}
