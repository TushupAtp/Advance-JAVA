package com.cdac.component.banking.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sbiAtm")
public class SbiAtm implements Atm {

	@Autowired
	private Bank bank;

	public void withdraw(int acno, double amount) {
		//Bank bank = new IciciBank();
		System.out.println("Customer at SbiAtm wants to withdraw " + amount + "rs.");
		bank.communicate(12345, "withdraw");
		//IciciBank ib = (IciciBank) bank;
	}	
}
