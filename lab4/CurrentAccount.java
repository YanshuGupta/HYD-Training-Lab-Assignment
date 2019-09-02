package com.cg.lab4;

public class CurrentAccount extends Account{

	private double overdraftLimit = 10000;
	
	public CurrentAccount(double balance, Person accHolder) {
		super(balance, accHolder);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount <= overdraftLimit) {
			super.withdraw(amount);
		}
		else {
			System.err.println("Overdraft Limit Reached");
		}
	}
}
