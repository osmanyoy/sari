package com.training.ee.cdi;

import javax.enterprise.inject.Any;
import javax.inject.Named;

@Any
@Named("name4")
public class MyImpl4 implements IMyInterface {

	@Override
	public String execute() {
		return "MyImpl4";
	}

}
