package com.training.ee.rest;

public class ErrorObject {
	private String message;
	private int cause;

	public ErrorObject(final String message, final int cause) {
		super();
		this.message = message;
		this.cause = cause;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public int getCause() {
		return this.cause;
	}

	public void setCause(final int cause) {
		this.cause = cause;
	}

}
