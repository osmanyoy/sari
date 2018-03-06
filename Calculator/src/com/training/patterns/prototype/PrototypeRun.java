package com.training.patterns.prototype;

public class PrototypeRun {
	public static void main(final String[] args) {
		CustomerFactory customerFactory = new CustomerFactory();
		Customer createCustomer = customerFactory.createCustomer(ECustomerType.ADMIN);

	}
}
