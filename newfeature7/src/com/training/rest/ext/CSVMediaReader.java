package com.training.rest.ext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.training.rest.Person;

@Provider
@Consumes("osman/csv")
public class CSVMediaReader implements MessageBodyReader<Person>{

	@Override
	public boolean isReadable(Class<?> type,
	                          Type genericType,
	                          Annotation[] annotations,
	                          MediaType mediaType) {
		return true;
	}

	@Override
	public Person readFrom(Class<Person> type,
	                       Type genericType,
	                       Annotation[] annotations,
	                       MediaType mediaType,
	                       MultivaluedMap<String, String> httpHeaders,
	                       InputStream entityStream)
	        throws IOException, WebApplicationException {
		Reader reader = new InputStreamReader(entityStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String readLine = bufferedReader.readLine();
		String[] split = readLine.split(",");
		Person person = new Person();
		person.setIsim(split[0]);
		person.setSoyisim(split[1]);
		person.setYas(Integer.parseInt(split[2]));
		person.setSehir(split[3]);
		person.setDepartment(split[4]);
		person.setCompany(split[5]);
		return person;
	}

}
