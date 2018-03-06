package com.training.patterns.nullpattern;

public class SampleObjec {
	private String name;
	private String surname;

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

	public String process(final String str) {
		return str + " " + this.name + " " + this.surname;
	}

}
