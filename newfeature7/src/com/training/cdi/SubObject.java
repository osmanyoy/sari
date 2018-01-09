package com.training.cdi;

import javax.enterprise.inject.Any;

@Any
public class SubObject {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
