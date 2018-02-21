package com.training.ee.cdi;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.training.ee.model.Person;

@Path("/cdi")
@SessionScoped
public class CDIRest implements Serializable {
    
    @Inject
    private PersonHolder personHolder;
    
    @Inject
    @Named("myProcess")
    private IProcess process;
    
    public CDIRest() {
        System.out.println("************** CDI Constructor called");
    }
    
    @Inject
    // @Named("osman1")
    // @MySelAnno
    @Named("impl3")
    private IExecute exec;
    
    @GET
    public String method1() {
        return exec.execute();
    }
    
    @PUT
    public String personPut(Person person) {
        personHolder.setPerson(person);
        return "OK";
    }
    
    @POST
    public String process() {
        return process.process(personHolder.getPerson());
    }

    
}
