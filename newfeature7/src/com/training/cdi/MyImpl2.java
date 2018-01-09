package com.training.cdi;

import javax.enterprise.inject.Default;

@Default
public class MyImpl2 implements IMyInterface{

	@Override
	public String execute() {
		return "Version 2";
	}

}
