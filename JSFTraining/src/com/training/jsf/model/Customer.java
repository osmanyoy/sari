package com.training.jsf.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private long customerId;
	
	@Size(min=3,max=30,message="30 dan fazla girdiniz")
	private String name;
	private String surname;
	private Integer age;
	@NotNull(message="birthdate girilmeli")
	private Date birthDate;
	
	private String city;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Address address;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="customer")
	private List<PhoneBookItem> phonebook;
	
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
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<PhoneBookItem> getPhonebook() {
		return phonebook;
	}
	public void setPhonebook(List<PhoneBookItem> phonebook) {
		this.phonebook = phonebook;
	}
	
	
	
	
}
