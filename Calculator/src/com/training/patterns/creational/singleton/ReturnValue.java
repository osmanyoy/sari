package com.training.patterns.creational.singleton;

public class ReturnValue {
	private String str;
	private boolean errorOccurred = false;

	public String getStr() {
		return str;
	}

	public ReturnValue setStr(String str) {
		this.str = str;
		return this;
	}

	public boolean isErrorOccurred() {
		return errorOccurred;
	}

	public ReturnValue setErrorOccurred(boolean errorOccurred) {
		this.errorOccurred = errorOccurred;
		return this;
	}
	
	
}
