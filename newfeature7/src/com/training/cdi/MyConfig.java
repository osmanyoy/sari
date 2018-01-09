package com.training.cdi;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class MyConfig {

	@Produces
	@Default
	public SubObject createSubObject(InjectionPoint injectionPoint) {
		System.out.println(injectionPoint.getMember().getName());
		SubObject subObject = new SubObject();
		subObject.setName("osman");
		return subObject;
	}
	
	
}
