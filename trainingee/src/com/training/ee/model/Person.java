package com.training.ee.model;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "Person", propOrder = { "name",
                                        "surname",
                                        "age" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	@XmlElement(name = "isim")
	@QueryParam("name")
	private String name;

	@QueryParam("surname")
	private String surname;

	@QueryParam("age")
	private int age;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

}
