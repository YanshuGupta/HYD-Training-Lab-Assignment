package com.cg.lab2;

import java.time.LocalDate;
import java.time.Period;

import com.cg.lab2.Person.GENDER;

public class Program1 {
	
	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("No Arguments are Passed");
		}
		else {
			int n = Integer.parseInt(args[0]);
			if(n >= 0)
				System.out.println("Number is Positive");
			else
				System.out.println("Number is Negative");
		}
		
		Person person = new Person("Yanshu", "Gupta", GENDER.M, "8979225022", LocalDate.of(1997, 4, 25));
		System.out.println(person);
		System.out.println(person.getAge());
		System.out.println(person.getFullName());
	}
	
}



class Person {	
	/*
	 * Funtionalities added in lab3
	 * 
	 * 1.	Accept DOB of Person 
	 * 2.	Calculate age of a person
	 * 3.	getting first and last Name Together
	 */
	private String firstName;
	private String lastName;
	private GENDER gender;
	private String phoneNumber;
	private LocalDate age;
	
	public Person(String firstName, String lastName, GENDER gender, String phoneNumber, LocalDate age) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}

	public String getAge() {
		Period period = Period.between(age, LocalDate.now());
		return period.getYears() +"-"+ period.getMonths() + "-" + period.getDays();
	}
	
	public String getFullName() {
		return firstName + lastName;
	}
	enum GENDER{
		M,F
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public GENDER getGender() {
		return gender;
	}
	public void setGender(GENDER gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
