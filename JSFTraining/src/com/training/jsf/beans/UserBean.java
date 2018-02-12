package com.training.jsf.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.jsf.dao.CustomerDAO;
import com.training.jsf.model.Customer;
import com.training.jsf.model.PhoneBookItem;

@Named
@SessionScoped
public class UserBean implements Serializable {
	
	private static final long serialVersionUID = -1576558618398355588L;

	private String username;
	private String password;
	
	private Customer customer;
	
	private boolean loggedIn = false;
	
	@EJB
	private CustomerDAO customerDAO;
	
	public String login() {
		Customer customer = customerDAO.getCustomer(username, password);
		if (customer != null) {
			this.setCustomer(customer);
			loggedIn = true;
			return "customert";
		}
		return "login";
	}
	
	public void checkLogin(ComponentSystemEvent systemEvent) {
		if (!loggedIn) {
			FacesContext context = FacesContext.getCurrentInstance();
			NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
			ConfigurableNavigationHandler cnh = (ConfigurableNavigationHandler) navigationHandler;
			cnh.performNavigation("login.xhtml");
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<PhoneBookItem> getPhoneBookItems(){
		return customerDAO.getAllPhoneList(customer);
	}
	
}
