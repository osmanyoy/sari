package com.training.ee.interceptor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("inter")
public class InterceptorRest {

	@Inject
	private Callee callee;

	@GET
	public String test() {
		return this.callee.hello();
	}

}
