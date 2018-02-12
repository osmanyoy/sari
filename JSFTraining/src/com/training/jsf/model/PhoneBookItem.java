package com.training.jsf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phonebook",indexes= {
		@Index(columnList="name,surname",unique= true,name="name_surname_index")
})
public class PhoneBookItem {
	
	@Id
	@GeneratedValue
	private long pbId;
	private String name;
	private String surname;
	private String phone;
	private String town;
	private String city;
	private String address;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Customer customer;
	
	public long getPbId() {
		return pbId;
	}
	public void setPbId(long pbId) {
		this.pbId = pbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
