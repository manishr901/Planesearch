package com.cgi.learning.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cgi.learning.common.HibernateUtils;

@WebServlet("/Registration")
public class Registration_servlet_hibernate extends HttpServlet {
	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Transaction tx = null;
		Session session = HibernateUtils.getSession();
		Registration_pojo registration_pojo = new Registration_pojo();
		registration_pojo.setName(req.getParameter("name"));
		registration_pojo.setEmail(req.getParameter("email"));
		registration_pojo.setPassword(req.getParameter("password"));
		registration_pojo.setContact(req.getParameter("contact"));
		registration_pojo.setBloodgroup(req.getParameter("blood_group"));
		registration_pojo.setStreet(req.getParameter("street"));
		registration_pojo.setArea(req.getParameter("area"));
		registration_pojo.setCity(req.getParameter("city"));
		registration_pojo.setDistrict(req.getParameter("dist"));
		tx=session.beginTransaction();
		try
		{
			session.save(registration_pojo);
		}
		catch(RuntimeException e)
		{
			throw e;
		}
		session.close();
		System.out.println("Registered");
		resp.sendRedirect("login.jsp");
	}

}
