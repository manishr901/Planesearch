package com.cgi.learning.common;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserTracker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7546157586917773287L;

	private static final UserTracker INSTANCE = new UserTracker();

	public static enum UserTrackerInstance {
		
		INSTANCE(UserTracker.INSTANCE);
		
		UserTracker instance;
		
		private UserTrackerInstance(UserTracker instance) {
			this.instance=instance;
		}
		
		public UserTracker getInstance(){
			return instance;
		}
		
	}

	private int currentUsers;

	private Set<String> users = new HashSet<>();

	private UserTracker() {

	}

	public synchronized void addUser(String userName) {
		users.add(userName);
		currentUsers++;

	}

	public synchronized void removeUser(String userName) {
		currentUsers++;
	}

	public int getCurrentUsers() {
		return currentUsers;
	}

	public int getTotalUsers() {
		return users.size();
	}
}
