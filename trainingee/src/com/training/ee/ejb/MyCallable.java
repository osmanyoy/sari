package com.training.ee.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import com.training.ee.model.Address;
import com.training.ee.model.EGender;
import com.training.ee.model.EmailAdresses;
import com.training.ee.model.Employee;
import com.training.ee.model.EmployeeInfo;

public class MyCallable implements Callable<Employee> {

	@Override
	public Employee call() throws Exception {
		try {
			Thread.sleep(10_000);
		} catch (Exception e) {
		}

		Employee employee = new Employee();
		employee.setName("osman");
		employee.setSurname("yay");
		employee.setGender(EGender.MALE);
		employee.setBirthdate(new Date());
		employee.setUsername("osman");
		employee.setPassword("1234");

		Address address = new Address();
		address.setCity("istanbul");
		address.setDistrict("umraniye");
		address.setStreet("harput");
		employee.setAddress(address);

		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setEducationLevel("uni");
		employeeInfo.setSpouseName("Nil");
		employee.setEmployeeInfo(employeeInfo);

		List<EmailAdresses> adresses = new ArrayList<>();
		EmailAdresses emailAdresse = new EmailAdresses();
		emailAdresse.setEmail("os@os.com");
		adresses.add(emailAdresse);
		emailAdresse.setEmployee(employee);

		emailAdresse = new EmailAdresses();
		emailAdresse.setEmail("os1@os1.com");
		adresses.add(emailAdresse);
		emailAdresse.setEmployee(employee);

		employee.setEmailAdresses(adresses);

		return employee;
	}

}
