package com.training.jsf.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.jsf.dao.PhoneBookDAO;
import com.training.jsf.model.City;
import com.training.jsf.model.PhoneBookItem;
import com.training.jsf.model.Town;

@Named
@RequestScoped
public class PhoneBookBean {
	
	
	@Inject
	private AddressManagerBean admngrBean;
	
	@Inject
	private PhoneBookItem phoneBookItem;
	
	@Inject
	private UserBean ub;
	
	@EJB
	private PhoneBookDAO phoneBookDAO;
	
	private String buttonName = "Add";

	public PhoneBookItem getPhoneBookItem() {
		return phoneBookItem;
	}

	public void setPhoneBookItem(PhoneBookItem phoneBookItem) {
		this.phoneBookItem = phoneBookItem;
	}
	
	public List<Town> getTowns(){
		City city = admngrBean.getCity(phoneBookItem.getCity());
		if (city != null) {
			return city.getTowns();
		}
		return null;
	}
	
	public boolean disableTown() {
		return phoneBookItem.getCity() == null;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	
	public void savePhoneEntry() {
		phoneBookItem.setCustomer(ub.getCustomer());
		phoneBookDAO.savePhoneEntry(phoneBookItem);
	}
}
