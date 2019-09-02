package com.cg.lab8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable{
	private int id;
	private String name;
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


public class Program1 {

	public static void main(String[] args) {
		
//		questionNumber1("yanshu.txt");
//		
//		questionNumber2("numbers.txt");
		
		questionNumber3("person.dat");
	}

	private static void questionNumber3(String fileName) {
		
		Person person1 = new Person(123, "Yanshu Gupta");
		Person person2 = new Person(124, "Nilesh Gupta");

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(person1);
			outputStream.writeObject(person2);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
			Object person;
			while((person = inputStream.readObject()) != null) {
				
				System.out.println((Person)person);
			}
			inputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void questionNumber2(String fileName) {
		
		List<Integer> list = new ArrayList<Integer>();
		int index = 0;
		try {
			FileReader fr = new FileReader(fileName);
			int c;
			while((c = fr.read()) != -1) {
				if(c == ',') {
					index++;	
					continue;
				}
				if(index == list.size()) {
					list.add(c-48);
				}
				else {
					int last = list.remove(index);
					list.add(last*10+c-48);
				}
			}
			list.forEach(s -> {if(s%2==0)System.out.println(s);});
			fr.close();
		} catch (IOException e) {
			System.err.println("Exception in reading file");
			e.printStackTrace();
		}
		System.out.println("END OF Question 2");
	}

	private static void questionNumber1(String fileName) {
		
		//String location = System.getProperty("user.id");
		StringBuilder sb = new StringBuilder();
		try {
			FileReader fr = new FileReader(fileName);
			int c;
			while((c = fr.read()) != -1) {
				sb.append((char)c);
			}
			fr.close();
		} catch (IOException e) {
			System.err.println("Exception in reading file");
			e.printStackTrace();
		}
		sb = sb.reverse();
		
		try {
			FileWriter fw = new FileWriter(fileName);
			for(char c: sb.toString().toCharArray()) {
				fw.write(c);
			}
			fw.close();
		} catch (IOException e) {
			System.err.println("Exception in writing file");
			e.printStackTrace();
		}
		System.out.println("END OF Question 1");
	}
}
