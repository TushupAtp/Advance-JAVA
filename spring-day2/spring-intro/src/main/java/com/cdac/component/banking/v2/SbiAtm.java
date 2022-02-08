package com.cdac.component.banking.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sbiAtmv2")
public class SbiAtm implements Atm {

	@Autowired
	private List<Bank> banks;

	public void withdraw(int acno, double amount) {
		//Bank bank = new IciciBank();
		System.out.println("Customer at SbiAtm wants to withdraw " + amount + "rs.");
		Bank currBank = null;
		for(Bank bank : banks) {
			if(bank.isExistingAccount(acno)) {
				currBank = bank;
				break;
			}
		}
		currBank.communicate(12345, "withdraw");
		//IciciBank ib = (IciciBank) bank;
	}	
}
