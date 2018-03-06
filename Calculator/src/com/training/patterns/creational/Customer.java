package com.training.patterns.creational;

public class Customer {
	
	private String name;
	private String surname;
	private int age;
	
	
	
//	public Customer(String name, String surname, int age) {
//		this.name = name;
//		this.surname = surname;
//		this.age = age;
//	}
//
//	public Customer(String name, String surname) {
//		this.name = name;
//		this.surname = surname;
//	}
//
//	public Customer(String name) {
//		this.name = name;
//	}
	
	private Customer() {
		
	}

	public static Customer createBEnimOzelMusterim(String name, String surname, int age) {
		Customer customer = new Customer();
		customer.name = name;
		customer.surname = surname;
		customer.age = age;
		return customer;
		
	}
	
	public static Customer createYakinMusterim(String name, String surname) {
		Customer customer = new Customer();
		customer.name = name;
		customer.surname = surname;
		return customer;
		
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public int getAge() {
		return age;
	}
	
	
}
