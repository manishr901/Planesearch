package com.cgi.learning.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.cgi.learning.common.UserTracker;
import com.cgi.learning.common.UserTracker.UserTrackerInstance;

@WebListener
public class SessionListener implements HttpSessionListener {
	private static final Logger log = Logger.getLogger(SessionListener.class.getName());

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		log.log(Level.INFO, "Session destoryed ");
		
//		HttpSession session = arg0.getSession();
//		String userName = (String) session.getAttribute("userName");
//		UserTracker tracker = UserTrackerInstance.INSTANCE.getInstance();
//		tracker.addUser(userName);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		log.log(Level.INFO, "Session destoryed ");
		HttpSession session = arg0.getSession();
		String userName = (String) session.getAttribute("userName");
		UserTracker tracker = UserTrackerInstance.INSTANCE.getInstance();
	}

}
