package com.training.ee.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.training.ee.model.Employee;

@Named
@RequestScoped
public class MyBean {
	private String name = "name";

	private Employee employee = new Employee();

	public String process() {
		return "sonuc";
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}

}
