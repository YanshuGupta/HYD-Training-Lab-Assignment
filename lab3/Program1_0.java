package com.cg.lab3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Formatter;

public class Program1 {

	public static void main(String[] args) {
		/*		
 		•	Add the String to itself
		•	Replace odd positions with #
		•	Remove duplicate characters in the String
		•	Change odd characters to upper case
		*/
		questionNumber1("MyInputString");
		
		/*
		Check String is positive or not
		if on moving from left to right each character in the String comes after the previous characters
		in the Alphabetical order
		*/
		System.out.println(questionNumber2("MyInputString"));
		
		/*
		 * Find Duration between current date and input date
		 */
		questionNumber3("1997-04-25");
		
		/*
		 * Find Duration between two dates
		 */
		questionNumber4("1997-04-25", "2019-08-31");

		/*
		 * Finding product Warrenty on basis of purchase date and period
		 */
		questionNumber5("2019-08-31", "0000-06-00");
		
		/*
		 * Find time According to Zone ID
		 */
		questionNumber6("America/New_York");
		questionNumber6("Europe/London");
		questionNumber6("Asia/Tokyo");
		
	}

	private static void questionNumber6(String input) {
		
		LocalDateTime dt = LocalDateTime.now(ZoneId.of(input));
		System.out.println(dt);
		
	}

	private static void questionNumber5(String input1, String input2) {
		Period period = Period.of(Integer.parseInt(input2.split("-")[0]), Integer.parseInt(input2.split("-")[1]), Integer.parseInt(input2.split("-")[2]));
		LocalDate dt = LocalDate.of(Integer.parseInt(input1.split("-")[0]), Integer.parseInt(input1.split("-")[1]), Integer.parseInt(input1.split("-")[2]));
		dt = dt.plusDays(period.getDays());
		dt = dt.plusMonths(period.getMonths());
		dt = dt.plusYears(period.getYears());
		System.out.println(dt);
	}

	private static void questionNumber4(String input1, String input2) {
		LocalDate dt = LocalDate.of(Integer.parseInt(input1.split("-")[0]), Integer.parseInt(input1.split("-")[1]), Integer.parseInt(input1.split("-")[2]));
		LocalDate dt2 = LocalDate.of(Integer.parseInt(input2.split("-")[0]), Integer.parseInt(input2.split("-")[1]), Integer.parseInt(input2.split("-")[2]));
		Period period = Period.between(dt2, dt);
		System.out.println("Period Between today date and given date");
		System.out.println("Years = "+ period.getYears());
		System.out.println("Months = "+ period.getMonths());
		System.out.println("Days = "+ period.getDays());		

	}

	private static void questionNumber3(String input) {
		
		LocalDate dt = LocalDate.now();
		LocalDate dt2 = LocalDate.of(Integer.parseInt(input.split("-")[0]), Integer.parseInt(input.split("-")[1]), Integer.parseInt(input.split("-")[2]));
		Period period = Period.between(dt2, dt);
		System.out.println("Period Between two given dates");
		System.out.println("Years = "+ period.getYears());
		System.out.println("Months = "+ period.getMonths());
		System.out.println("Days = "+ period.getDays());		
	}

	private static boolean questionNumber2(String input) {
		// Checking String Positive or not
		for(int i=1;i<input.length();i++) {
			if(input.charAt(i) < input.charAt(i-1))	return false;
		}
		return true;
	}

	private static void questionNumber1(String input) {
		
		System.out.println("Add the String to itself = "+input+input);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length();i++) {
			if(i%2==0) {
				sb.append(input.charAt(i));
			}
			else {
				sb.append('#');
			}
		}
		System.out.println("Replace odd positions with # = "+ sb);
		
		String s3 = "";
		for(char c: input.toCharArray()) {
			if(!s3.contains(String.valueOf(c))){
				s3 = s3+c;
			}
		}
		System.out.println("Remove duplicate characters in the String = "+ s3);
		
		StringBuilder sb4 = new StringBuilder();
		for(int i=0;i<input.length();i++) {
			if(i%2==0) {
				sb4.append(input.charAt(i));
			}
			else {
				sb4.append(Character.toUpperCase(input.charAt(i)));
			}
		}
		System.out.println("Change odd characters to upper case = "+ sb4);
	}
}
