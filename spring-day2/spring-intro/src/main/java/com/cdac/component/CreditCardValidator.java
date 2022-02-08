package com.cdac.component;

public interface CreditCardValidator {

	public boolean isValid(long cardno, String expiryDate, int cvv);
}
