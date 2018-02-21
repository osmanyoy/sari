package com.training.ee.interceptor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.training.ee.cdi.PersonHolder;
import com.training.ee.model.Person;

@Path("/inter")
public class InterceptorRest {
    
    @Inject
    private PersonHolder holder;
    
    @Inject
    private TestConstructorInterceptor testConstructorInterceptor;
    
    @Inject
    private MyObject myObject;
    
    @GET
    public String runMyObjectMethod() {
        return myObject.doSomething();
    }
    
    @POST
    @Produces({"application/json"})
    public TestConstructorInterceptor myMethod(Person person) {
        testConstructorInterceptor.setPerson(person);
        return testConstructorInterceptor;
    }
    
    
}
