package com.training.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionHandler implements ExceptionMapper<MyException> {

	@Override
	public Response toResponse(MyException exp) {

		ErrorObject errorObject = new ErrorObject();
		errorObject.setCauseDescription(exp.getCauseDescription());
		errorObject.setCauseCode(exp.getCauseCode());

		return Response.status(Status.BAD_REQUEST)
		               .entity(errorObject)
		               .type(MediaType.APPLICATION_JSON)
		               .build();
	}

}
