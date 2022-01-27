package com.cdac.service;

public class DummyLoginService implements LoginService {

	public boolean isValidUser(String username, String password) {
		if(username.equals("majrul") && password.equals("123"))
			return true;
		return false;
	}

}
