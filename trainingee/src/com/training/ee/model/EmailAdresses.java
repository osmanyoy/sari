package com.training.ee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class EmailAdresses {
	@Id
	@GeneratedValue
	private long emId;
	private String email;

	@ManyToOne
	@XmlTransient
	private Employee employee;

	public long getEmId() {
		return this.emId;
	}

	public void setEmId(final long emId) {
		this.emId = emId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}

}
