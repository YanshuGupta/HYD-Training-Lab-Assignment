package com.cg.lab4;

public class SavingAccount extends Account{

	private final double minimumBalance = 500.0;
	
	public SavingAccount(double balance, Person accHolder) {
		super(balance, accHolder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdraw(double amount) {
		if(super.getBalance() - amount >= 0) {
			super.withdraw(amount);
		}
		else {
			// must throw Exception 
			System.err.println("withdraw amount is greater then current balance");
		}
	}
	
}
