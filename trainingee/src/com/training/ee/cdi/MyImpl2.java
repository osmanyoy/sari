package com.training.ee.cdi;

import javax.enterprise.inject.Any;

@Any
public class MyImpl2 implements IMyInterface {

	@Override
	public String execute() {
		return "MyImpl2";
	}

}
