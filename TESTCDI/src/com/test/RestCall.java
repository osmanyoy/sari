package com.test;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/test")
@DeclareRoles({ "group1",
                "admin" })
@RequestScoped
public class RestCall implements Serializable {

	private static final long serialVersionUID = 6635624795366473311L;

	private int countx = 0;

	@Inject
	@Named("executeV2")
	private IExecute execute;

	@RolesAllowed("admin")
	@GET
	public String exec() {
		return "C:" + this.countx++ + this.execute.execute();
	}

	@Path("/test/{isim}")
	@GET
	@Produces({ "application/json" })
	public Employee test(@PathParam("isim") final String isim, @QueryParam("soy") final String soy,
	        @HeaderParam("pass") final String password) {
		Employee employee = new Employee();
		employee.setName(isim);
		employee.setSurname(soy);
		employee.setUsername("user" + isim);
		employee.setPassword(password);
		employee.setBirthdate(new Date());
		return employee;
	}

}
