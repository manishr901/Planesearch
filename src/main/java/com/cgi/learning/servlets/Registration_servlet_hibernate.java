package com.cgi.learning.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration_servlet_hibernate extends HttpServlet {

	public static EntityManager em;

	private static final Logger log = Logger.getLogger(Registration_servlet_hibernate.class.getName());
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();

		createdetails(req.getParameter("name"),req.getParameter("email"),req.getParameter("password"),req.getParameter("contact"),req.getParameter("blood_group"),req.getParameter("street"),req.getParameter("area"),
				req.getParameter("city"),req.getParameter("dist"));
		
		log.log(Level.INFO, "Succesfullt inseerted " );
	resp.sendRedirect("Login.jsp");

	}

	public static void createdetails(String name, String email, String password, String bloodgroup, String contact,
			String city, String street, String area, String district) {
		em.getTransaction().begin();
		Registration_pojo Reg = new Registration_pojo(name, email, password, bloodgroup, contact, city, street, area, district);
		em.persist(Reg);
		em.getTransaction().commit();
	
	}

}
