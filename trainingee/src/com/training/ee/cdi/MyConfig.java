package com.training.ee.cdi;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class MyConfig {

	@Produces
	@Default
	public IMyInterface myInterface() {
		return new MyImpl2();
	}

	@Produces
	@MySelector
	public IMyInterface myInterface2() {
		return new MyImpl3();
	}

	@Produces
	@Any
	@Named("osman")
	public IMyInterface myInterface3() {
		return new MyImpl1();
	}

}
