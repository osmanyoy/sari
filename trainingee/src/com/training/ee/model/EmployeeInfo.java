package com.training.ee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeInfo {
	@Id
	@GeneratedValue
	private long empInfoId;

	private String spouseName;
	private String educationLevel;

	public String getSpouseName() {
		return this.spouseName;
	}

	public void setSpouseName(final String spouseName) {
		this.spouseName = spouseName;
	}

	public String getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(final String educationLevel) {
		this.educationLevel = educationLevel;
	}

}
