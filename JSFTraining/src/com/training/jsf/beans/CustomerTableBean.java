package com.training.jsf.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.training.jsf.dao.CustomerDAO;
import com.training.jsf.model.Customer;

@Named("ctb")
@RequestScoped
public class CustomerTableBean implements Serializable{
	private static final long serialVersionUID = 8103414397437856148L;
	
	private Customer customer = new Customer();
	
	@EJB
	private CustomerDAO customerDAO;
	
	public List<Customer> getCustomerList(){
		return customerDAO.getAllCustomers();
	}
	
	public String editCustomer(Customer customer) {
		this.customer = customer;
		return "customeredit";
	}
	
	public String deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
		return "customertable";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String updateCustomer() {
		customerDAO.updateCustomer(customer);
		return "customertable";
	}
}
