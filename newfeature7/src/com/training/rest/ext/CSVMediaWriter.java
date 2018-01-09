package com.training.rest.ext;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.training.rest.Person;

@Provider
@Produces("osman/csv")
public class CSVMediaWriter implements MessageBodyWriter<Person> {

	@Override
	public boolean isWriteable(Class<?> type,
	                           Type genericType,
	                           Annotation[] annotations,
	                           MediaType mediaType) {
		return true;
	}

	@Override
	public long getSize(Person t,
	                    Class<?> type,
	                    Type genericType,
	                    Annotation[] annotations,
	                    MediaType mediaType) {
		return 0;
	}

	@Override
	public void writeTo(Person person,
	                    Class<?> type,
	                    Type genericType,
	                    Annotation[] annotations,
	                    MediaType mediaType,
	                    MultivaluedMap<String, Object> httpHeaders,
	                    OutputStream entityStream)
	        throws IOException, WebApplicationException {
		String str = person.getIsim()
		             + ","
		             + person.getSoyisim()
		             + ","
		             + person.getYas()
		             + ","
		             + person.getSehir()
		             + ","
		             + person.getDepartment()
		             + ","
		             + person.getCompany();
		entityStream.write(str.getBytes());
	}

}
