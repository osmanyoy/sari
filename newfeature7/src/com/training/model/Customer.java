package com.training.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Musteri", indexes = { @Index(columnList = "isim,surname") })
@SecondaryTable(name="Musteri_second")
public class Customer {

	@Id
	@GeneratedValue
	private long customerId;
	@Column(name = "isim", nullable = false, length = 50)
	private String name;
	private String surname;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CustomerCredential customerCred;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Orders> orders;

	// @Basic(fetch=FetchType.LAZY)
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Embedded
	private Address address;
	
	@Column(table="Musteri_second")
	private String spouseName;
	
	@Column(table="Musteri_second")
	private int years;
	
	@Convert(converter=com.training.jpa.ColorConverter.class)
	private Color color;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public CustomerCredential getCustomerCred() {
		return customerCred;
	}

	public void setCustomerCred(CustomerCredential customerCred) {
		this.customerCred = customerCred;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
