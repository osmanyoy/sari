package com.training.patterns.creational.builder;

public class CustomerEx {

	private String name;
	private String surname;
	private int age;

	private CustomerEx() {
		
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
	
	public static CustomerExBuilder getBuilder() {
		return new CustomerExBuilder();
	}

	public static class CustomerExBuilder {
		
		private String name;
		private String surname;
		private int age;
		
		private CustomerExBuilder() {
		}

		public String getName() {
			return name;
		}

		public CustomerExBuilder mandatoryName(String name) {
			this.name = name;
			return this;
		}

		public String getSurname() {
			return surname;
		}

		public CustomerExBuilder mandatorySurname(String surname) {
			this.surname = surname;
			return this;
		}

		public int getAge() {
			return age;
		}

		public CustomerExBuilder optionalAge(int age) {
			this.age = age;
			return this;
		}
		
		public CustomerEx build() {
			
			if (name == null) {
				throw new IllegalArgumentException("name can not be null ");
			}
			CustomerEx customerEx = new CustomerEx();
			customerEx.name = name;
			customerEx.surname = surname;
			customerEx.age = age;
			return customerEx;
		}
		
	}
}
