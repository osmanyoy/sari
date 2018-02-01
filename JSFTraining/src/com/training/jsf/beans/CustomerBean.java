package com.training.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.jsf.dao.CustomerDAO;
import com.training.jsf.model.Customer;

@Named("musteri")
@RequestScoped
public class CustomerBean {

	private static List<String> cityList = new ArrayList<>();

	static {
		cityList.add("Adana");
		cityList.add("Ankara");
		cityList.add("Ýstanbul");
	}
	
	private String buttonName = "Save"; 
	
	private String offer;

	@Inject
	private Customer customer;

	@EJB
	private CustomerDAO customerDAO;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String saveCustomer() {
		customerDAO.saveCustomer(customer);
		return "custview";
	}

	public void saveCustomerAction(ActionEvent actionEvent) {
		if (customer.getCustomerId() == 0) {
			customerDAO.saveCustomer(customer);
		} else {
			customerDAO.updateCustomer(customer);
		}
		customer = new Customer();
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void editCustomer(Customer cst) {
		customer = cst;
		buttonName= "Update";
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	public void offerAction() {
		if (customer.getName() != null && customer.getName().startsWith("o")) {
			offer = "osman";
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("offering osman",  "Osman offerred") );
		}
		
	}

	public void offerUpdate() {
		customer.setName(offer);
	}

}
