package com.training.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.training.rest.Person;

@WebService
public class HelloWS {
	
	public Person helloPerson(@WebParam(name="name") String name) {
		Person person = new Person();
		person.setIsim(name);
		person.setSoyisim("soy");
		person.setYas(47);
		return person;
	}
	
	@WebMethod(exclude=true)
	public String test() {
		return "test";
	}
}	
