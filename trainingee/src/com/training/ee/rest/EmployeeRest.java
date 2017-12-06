package com.training.ee.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.training.ee.cdi.IMyInterface;
import com.training.ee.cdi.MySelector;
import com.training.ee.ejb.EmployeeDAO;
import com.training.ee.model.Address;
import com.training.ee.model.EGender;
import com.training.ee.model.EmailAdresses;
import com.training.ee.model.Employee;
import com.training.ee.model.EmployeeInfo;

@Path("/employee")
public class EmployeeRest {

	@Inject
	private IMyInterface mi;

	@Inject
	@MySelector
	private IMyInterface mi2;

	@Inject
	@Named("name4")
	private IMyInterface mi3;

	@EJB
	private EmployeeDAO ed;

	@GET
	@Path("/cdi")
	public String cdiTest() {
		return this.mi.execute() + " mi2 : " + this.mi2.execute() + " mi3 : " + this.mi3.execute();
	}

	@DELETE
	public Response name(@QueryParam("id") final long empId) {
		this.ed.deleteEmployee(this.ed.getEmployee(empId));
		return Response.ok()
		               .build();
	}

	@GET
	public Response writeEmployee() {
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

		this.ed.save(employee);
		return Response.ok()
		               .build();
	}

	@Path("/all")
	@Produces({ "application/xml" })
	@GET
	public EmployeeList getAllEmployee() {
		List<Employee> allEmployees = this.ed.getAllEmployees();
		allEmployees = this.ed.fillAllEmployee(allEmployees);
		EmployeeList employeeList = new EmployeeList();

		for (Employee employee : allEmployees) {
			EmployeeInfo employeeInfo = employee.getEmployeeInfo();
			employeeList.getEmployees()
			            .add(employee);
			System.out.println(employeeInfo);
		}
		return employeeList;
	}
}
