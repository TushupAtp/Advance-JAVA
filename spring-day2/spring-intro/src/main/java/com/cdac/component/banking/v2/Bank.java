package com.cdac.component.banking.v2;

public interface Bank {

	public void communicate(int atmId, String action);
	public boolean isExistingAccount(int acno);
}
