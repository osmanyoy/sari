package com.training.ee.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.training.ee.model.Person;

public class MyConfigure {
    
    @Produces
    @Named("impl3")
    @Dependent
    // @RequestScoped
    public IExecute createExecute(Person person) {
        System.out.println("Person : " + person );
        return new ExecuteImpl3();
    }
    
}
