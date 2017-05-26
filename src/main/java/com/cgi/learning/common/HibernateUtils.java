package com.cgi.learning.common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory = buildSessionFactory();
	static Session session = null;

	public static SessionFactory buildSessionFactory() {
		if (null == sessionFactory) {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
			registryBuilder.applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(registryBuilder.configure().build());
		}

		return sessionFactory;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;

	}

	public static Session newSession() {
		
		return sessionFactory.openSession();

	}

	public static Session getSession() {
		if (null == session) {
			session=newSession();
		}
		
		try{
			session =sessionFactory.getCurrentSession();
		}
		catch (HibernateException e){
			
			
			
		}
		return session;

	}
}
