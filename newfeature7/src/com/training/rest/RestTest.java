package com.training.rest;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.training.ejb.MyFirstStatelessEJB;
import com.training.rest.ext.LogMe;

@Path("/test")
public class RestTest {

	@EJB
	private MyFirstStatelessEJB myFirst; 
	
	@GET
	public String hello() {
		return myFirst.hello();
	}

	@GET
	@Path("/2")
	public String hello2() {
		return "hello world 2";
	}

	@GET
	@Path("/3/{name}")
	public String hello3(@PathParam("name") String isim) {
		return "hello world 3 : "
		       + isim;
	}

	@GET
	@Path("/4/{name}/{surname}")
	public String hello4(@PathParam("name") String isim,
	                     @PathParam("surname") String soyisim,
	                     @QueryParam("age") int yas,
	                     @QueryParam("city") String sehir) {
		return "hello world 4 : "
		       + isim
		       + " "
		       + soyisim
		       + " age : "
		       + yas
		       + " city : "
		       + sehir;
	}

	@POST
	@Path("/5")
	public String hello5(@MatrixParam("name") String isim,
	                     @MatrixParam("surname") String soyisim,
	                     @FormParam("age") int yas,
	                     @FormParam("city") String sehir) {
		return "hello world 4 : "
		       + isim
		       + " "
		       + soyisim
		       + " age : "
		       + yas
		       + " city : "
		       + sehir;
	}

	@POST
	@Path("/6")
	public String hello6(@MatrixParam("name") String isim,
	                     @MatrixParam("surname") String soyisim,
	                     @FormParam("age") int yas,
	                     @FormParam("city") String sehir,
	                     @HeaderParam("department") String department,
	                     @HeaderParam("company") String company) {
		return "hello world 6 : "
		       + isim
		       + " "
		       + soyisim
		       + " age : "
		       + yas
		       + " city : "
		       + sehir
		       + " department : "
		       + department
		       + " company : "
		       + company;
	}

	@POST
	@Path("/7")
	public String hello7(@BeanParam Person person) throws MyException {

		if (person.getIsim() == null
		    || person.getIsim()
		             .equals("")) {
			throw new MyException("isim boþ olamaz",
			                      100);
		}

		return "hello world 6 : "
		       + person.getIsim()
		       + " "
		       + person.getSoyisim()
		       + " age : "
		       + person.getYas()
		       + " city : "
		       + person.getSehir()
		       + " department : "
		       + person.getDepartment()
		       + " company : "
		       + person.getCompany();
	}

	@POST
	@Path("/8")
	public String hello8(@BeanParam Person person) {

		if (person.getIsim() == null
		    || person.getIsim()
		             .equals("")) {
			ErrorObject errorObject = new ErrorObject();
			errorObject.setCauseDescription("isim boþ olamaz");
			errorObject.setCauseCode(200);

			Response resp = Response.status(Status.BAD_REQUEST)
			                        .entity(errorObject)
			                        .type(MediaType.APPLICATION_JSON)
			                        .build();
			throw new WebApplicationException(resp);
		}

		return "hello world 6 : "
		       + person.getIsim()
		       + " "
		       + person.getSoyisim()
		       + " age : "
		       + person.getYas()
		       + " city : "
		       + person.getSehir()
		       + " department : "
		       + person.getDepartment()
		       + " company : "
		       + person.getCompany();
	}

	@POST
	@Path("/9")
	public String hello9(@Valid @BeanParam Person person) {
		return "hello world 6 : "
		       + person.getIsim()
		       + " "
		       + person.getSoyisim()
		       + " age : "
		       + person.getYas()
		       + " city : "
		       + person.getSehir()
		       + " department : "
		       + person.getDepartment()
		       + " company : "
		       + person.getCompany();
	}

	@POST
	@Path("/10")
	public Response hello10(@BeanParam Person person) {
		if (person.getIsim() == null || person.getIsim().equals("")) {
			return Response.status(Status.NO_CONTENT).entity("isim boþ olamaz").build();
		}
		return Response.ok("hello world 6 : "
		                   + person.getIsim()
		                   + " "
		                   + person.getSoyisim()
		                   + " age : "
		                   + person.getYas()
		                   + " city : "
		                   + person.getSehir()
		                   + " department : "
		                   + person.getDepartment()
		                   + " company : "
		                   + person.getCompany())
		               .build();
	}

	@POST
	@Path("/11")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,"osman/csv"})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,"osman/csv"})
	public Response hello11(Person person) {
		if (person.getIsim() == null || person.getIsim().equals("")) {
			return Response.status(Status.NO_CONTENT).entity("isim boþ olamaz").build();
		}
		return Response.ok(person)
		               .build();
	}

	@LogMe
	@POST
	@Path("/12")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,"osman/csv"})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,"osman/csv"})
	public Response hello12(Person person) {
		if (person.getIsim() == null || person.getIsim().equals("")) {
			return Response.status(Status.NO_CONTENT).entity("isim boþ olamaz").build();
		}
		person.setIsim(myFirst.hello());
		return Response.ok(person)
		               .build();
	}

}
