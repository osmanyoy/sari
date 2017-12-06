package com.training.ee.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.util.HttpResponseCodes;

@Provider
public class MyExceptionMapper implements ExceptionMapper<MyException> {

	@Override
	public Response toResponse(final MyException exception) {
		return Response.status(HttpResponseCodes.SC_CONFLICT)
		               .entity(new ErrorObject(exception.getMymessage(),
		                                       exception.getMycause()))
		               .build();
	}

}
