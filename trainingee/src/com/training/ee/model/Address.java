package com.training.ee.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "testCity")
	private String city;
	private String street;
	private String district;

	public String getCity() {
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(final String district) {
		this.district = district;
	}

}
