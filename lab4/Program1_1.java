package com.cg.lab4;

public class Program1 {

	public static void main(String[] args) {
		
		Account smithAcc = new Account(2000.00, new Person("Smith", 22));
		Account kathyAcc = new Account(3000.00, new Person("Kathy", 22));
		
		smithAcc.deposite(2000.0);
		kathyAcc.withdraw(2000.0);
		
		System.out.println(smithAcc);
		System.out.println(kathyAcc);
	}
}
