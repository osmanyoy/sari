package com.training.jsf;


public class SecondObject {
	private String name = "default";
	private long id = 1;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SecondObject [name=" + name + ", id=" + id + "]";
	}
	
	
	
}
