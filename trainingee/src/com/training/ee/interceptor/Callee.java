package com.training.ee.interceptor;

@NewInterceptor
public class Callee {

	@MyAnno(myValue = "test")
	private String str;

	@LogInterceptor
	public String hello() {
		return this.str;
	}

}
