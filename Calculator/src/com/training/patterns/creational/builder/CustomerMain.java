package com.training.patterns.creational.builder;

import com.training.patterns.creational.Customer;

public class CustomerMain {
	private void mai() {
		Customer customer = Customer.createBEnimOzelMusterim("osman",
		                                                     "yaycioglu",
		                                                     48);

		CustomerEx build = CustomerEx.getBuilder()
		                             .mandatoryName("osman")
		                             .mandatorySurname("aya")
		                             .optionalAge(48)
		                             .build();
		
	}
}
