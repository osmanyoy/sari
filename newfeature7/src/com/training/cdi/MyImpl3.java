package com.training.cdi;


import javax.enterprise.inject.Default;

@MyQualifier
public class MyImpl3 implements IMyInterface{

	@Override
	public String execute() {
		return "Version 3";
	}

}
