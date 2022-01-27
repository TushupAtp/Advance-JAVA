package com.cdac.service;

import java.util.HashMap;

public class InMemoryLoginService implements LoginService {

	private HashMap<String, String> users = new HashMap<String, String>();
	
	public InMemoryLoginService() {
		users.put("majrul", "123");
		users.put("saurabh", "456");
		users.put("amol", "789");
		users.put("swati", "000");
	}
	
	public boolean isValidUser(String username, String password) {
		if(users.containsKey(username))
			if(users.get(username).equals(password))
				return true;
		return false;			
	}
}
