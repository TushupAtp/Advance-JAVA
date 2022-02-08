package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("ccValidator")
public class MyCreditCardValidator implements CreditCardValidator {

	public boolean isValid(long cardno, String expiryDate, int cvv) {
		return true; //real code missing right now
	}
	
}
