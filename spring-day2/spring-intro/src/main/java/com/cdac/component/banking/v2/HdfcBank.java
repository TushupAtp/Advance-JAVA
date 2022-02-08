package com.cdac.component.banking.v2;

import org.springframework.stereotype.Component;

@Component("hdfcBankv2")
public class HdfcBank implements Bank {

	public void communicate(int atmId, String action) {
		System.out.println("Communication established with HdfcBank from ATM " + atmId + " for " + action);
	}
	
	public boolean isExistingAccount(int acno) {
		if(acno == 987654321)
			return true;
		return false;
	}
}
