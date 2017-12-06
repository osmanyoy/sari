package com.training.ee.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.training.ee.model.Employee;

@XmlRootElement
public class EmployeeList {
	private List<Employee> employees = new ArrayList<>();

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(final List<Employee> employees) {
		this.employees = employees;
	}

}
