package com.training.cdi;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;

@Any
@Named("osman")
public class MyImpl implements IMyInterface{

	@Inject
	private SubObject sub;
	
	@Override
	public String execute() {
		return "Version 1 " + sub.getName() ;
	}

}
