package com.training.customer;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.training.cdi.IMyInterface;
import com.training.cdi.MyQualifier;
import com.training.ejb.CustomerDAO;
import com.training.model.Customer;
import com.training.model.Orders;

@Path("/customer")
public class CustomerRest {
	
	@EJB
	private CustomerDAO customerDAO;
	
	@Inject
	@Named("osman")
	// @MyQualifier
	private IMyInterface myInt;
	
	@GET
	@Path("/cdi")
	public String executeMyInterface() {
		return myInt.execute();
	}
	
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response writeCustomer(Customer customer) {
		List<Orders> orders = customer.getOrders();
		for (Orders order : orders) {
			order.setCustomer(customer);
		}
		customerDAO.insert(customer);
		return Response.ok("Success").build();
	}
	
	@GET
	@Path("/remove/{customerId}")
	public Response removeCustomer(@PathParam("customerId") long id) {
		Customer customer = new Customer();
		customer.setCustomerId(id);
		customerDAO.delete(customer);
		return Response.ok("Success").build();
	}
	
	@POST
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateCustomer(Customer customer) {
		customerDAO.update(customer);
		return Response.ok("Success").build();
	}
	
	@POST
	@Path("/addAll")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response writeCustomer(List<Customer> customers) {
		customerDAO.insertAll(customers);
		return Response.ok("Success").build();
	}

	@GET
	@Path("/getAll")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Customer> getAllCustomers() {
		
		return customerDAO.getAllCustomers();
	}

}
