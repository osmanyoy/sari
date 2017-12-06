package com.training.ee.rest;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8840927145459970695L;
	private String mymessage;
	private int mycause;

	public MyException(final String message, final int cause) {
		super();
		this.mymessage = message;
		this.mycause = cause;
	}

	public String getMymessage() {
		return this.mymessage;
	}

	public void setMymessage(final String mymessage) {
		this.mymessage = mymessage;
	}

	public int getMycause() {
		return this.mycause;
	}

	public void setMycause(final int mycause) {
		this.mycause = mycause;
	}

}
