package com.training.ee.rest;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.util.HttpResponseCodes;

import com.training.ee.model.Person;

@Path("/m")
@SessionScoped
public class MyRestService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8057811941146245578L;

	@GET
	public String helloWorld() {
		return "hello";
	}

	@Path("/n/{name}/{surname}")
	@GET
	public String hello(@Size(min = 4, message = "test") @PathParam("name") final String name,
	        @PathParam("surname") final String surname) {
		return "Hello " + name + " " + surname;
	}

	@Path("/o")
	@GET
	public String hello2(@QueryParam("name") final String name, @QueryParam("surname") final String surname) {
		return "Hello " + name + " " + surname;
	}

	@Path("/p")
	@GET
	public String hello3(@MatrixParam("name") final String name, @MatrixParam("surname") final String surname) {
		return "Hello " + name + " " + surname;
	}

	@Path("/r")
	@GET
	public String hello4(@HeaderParam("name") final String name, @HeaderParam("surname") final String surname) {
		return "Hello " + name + " " + surname;
	}

	@Path("/s")
	@GET
	public String hello5(@CookieParam("name") final String name, @CookieParam("surname") final String surname) {
		return "Hello " + name + " " + surname;
	}

	@Path("/t")
	@POST
	public String hello6(@FormParam("name") final String name, @FormParam("surname") final String surname) {
		return "Hello " + name + " " + surname;
	}

	@Path("/u")
	@GET
	public String hello7(@BeanParam final Person person) {
		return "Hello " + person.getName() + " " + person.getSurname();
	}

	@Path("/u1")
	@GET
	@Produces({ MediaType.APPLICATION_XML,
	            MediaType.APPLICATION_JSON })
	public Person hello7a(@BeanParam final Person person) {
		return person;
	}

	@Path("/v")
	@POST
	@Consumes({ MediaType.APPLICATION_XML,
	            MediaType.APPLICATION_JSON })
	public String hello8(final Person person) {
		return "Hello " + person.getName() + " " + person.getSurname();
	}

	@Path("/z/{name}/{age}")
	@GET
	public String hello20(@Size(min = 4, message = "{my.key}") @PathParam("name") final String name,
	        @Min(100) @PathParam("age") final Integer age) {

		return "Hello " + name + " " + age;
	}

	@Path("/z1/{name}/{age}")
	@GET
	public String hello21(@PathParam("name") final String name, @PathParam("age") final Integer age) {
		if (name.length() < 4) {
			throw new WebApplicationException(Response.status(HttpResponseCodes.SC_BAD_GATEWAY)
			                                          .entity(new ErrorObject("isim 4 den küçük olamaz",
			                                                                  5))
			                                          .build());
		}
		return "Hello " + name + " " + age;
	}

	@Path("/z2/{name}/{age}")
	@GET
	public Response hello22(@PathParam("name") final String name, @PathParam("age") final Integer age) {
		if (name.length() < 4) {
			return Response.status(HttpResponseCodes.SC_BAD_GATEWAY)
			               .entity(new ErrorObject("isim 4 den küçük olamaz",
			                                       5))
			               .build();
		}
		return Response.status(HttpResponseCodes.SC_BAD_GATEWAY)
		               .entity("Hello " + name + " " + age)
		               .build();
	}

	@Path("/z3/{name}/{age}")
	@GET
	public String hello23(@PathParam("name") final String name, @PathParam("age") final Integer age)
	        throws MyException {
		if (name.length() < 4) {
			throw new MyException("test",
			                      100);
		}
		return "Hello " + name + " " + age;
	}

}
