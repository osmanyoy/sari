package com.training.ee.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.training.ee.model.Person;

@WebService(targetNamespace = "http://person.adenon.com/v1")
public class MyWebService {

	public Person getPerson(@WebParam(name = "id") final long id) {
		Person person = new Person();
		person.setName("osman");
		person.setSurname("Yaycýoðlu");
		return person;
	}

	@WebMethod(exclude = true)
	public Person notwanted() {
		Person person = new Person();
		person.setName("osman");
		person.setSurname("Yaycýoðlu");
		return person;

	}

}
