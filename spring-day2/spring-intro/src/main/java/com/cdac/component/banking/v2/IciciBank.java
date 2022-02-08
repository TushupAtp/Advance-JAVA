package com.cdac.component.banking.v2;

import org.springframework.stereotype.Component;

@Component("iciciBankv2")
public class IciciBank implements Bank {

	public void communicate(int atmId, String action) {
		System.out.println("Communication established with IciciBank from ATM " + atmId + " for " + action);
	}
	
	public boolean isExistingAccount(int acno) {
		if(acno == 123456789)
			return true;
		return false;
	}
}
