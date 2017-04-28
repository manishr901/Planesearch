package com.cgi.learning.servlets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Registration_Main {
	public static EntityManager em;

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();

		createdetails("Manish","aws5@gmnail.com","password","23233223","o+", "patna1_street", "shastrinagar", "patna", "patna_district");
	
	}
	public static void createdetails(String name, String email, String password, String bloodgroup, String contact, String city, String street, String area, String district) {
		em.getTransaction().begin();
	Registration_pojo Reg= new Registration_pojo(name,email,password,bloodgroup,contact,city,street,area,district);
	em.persist(Reg);
	em.getTransaction().commit();
	}

}
