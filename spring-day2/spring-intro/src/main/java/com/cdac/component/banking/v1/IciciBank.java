package com.cdac.component.banking.v1;

import org.springframework.stereotype.Component;

@Component("iciciBank")
public class IciciBank implements Bank {

	public void communicate(int atmId, String action) {
		System.out.println("Communication established with IciciBank from ATM " + atmId + " for " + action);
	}
	
	public void headOfficeDetails() {
		
	}
}
