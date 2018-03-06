package com.training.patterns.prototype;

import java.util.List;

public class Customer implements Cloneable {
	private String name;
	private String surname;
	private List<String> roles;
	private List<String> group;
	private ECustomerType customerType;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Customer customer = new Customer();
		customer.roles = this.roles;
		customer.group = this.group;
		return customer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public List<String> getRoles() {
		return this.roles;
	}

	public void setRoles(final List<String> roles) {
		this.roles = roles;
	}

	public List<String> getGroup() {
		return this.group;
	}

	public void setGroup(final List<String> group) {
		this.group = group;
	}

	public ECustomerType getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(final ECustomerType customerType) {
		this.customerType = customerType;
	}

}
