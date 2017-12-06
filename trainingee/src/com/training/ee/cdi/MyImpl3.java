package com.training.ee.cdi;

import javax.enterprise.inject.Any;

@Any
public class MyImpl3 implements IMyInterface {

	@Override
	public String execute() {
		return "MyImpl3";
	}

}
