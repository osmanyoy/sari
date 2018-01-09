package com.training.rest;

public class MyException extends Exception {
	
	private static final long serialVersionUID = -3989891427687404942L;
	
	private String causeDescription;
	private int causeCode;
	
	public MyException(String causeDescription, int causeCode) {
		super();
		this.causeDescription = causeDescription;
		this.causeCode = causeCode;
	}
	
	
	public String getCauseDescription() {
		return causeDescription;
	}
	public void setCauseDescription(String causeDescription) {
		this.causeDescription = causeDescription;
	}
	public int getCauseCode() {
		return causeCode;
	}
	public void setCauseCode(int causeCode) {
		this.causeCode = causeCode;
	}
	
	
}
