package com.training.ee.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.training.ee.model.Person;

public class ProcessConfigure {
    
    @Produces
    @Named("myProcess")
    @RequestScoped
    public IProcess createProcessor(PersonHolder personHolder) {
        Person person = personHolder.getPerson();
        if (person == null) {
            return null;
        }
        if (person.getCinsiyet().equalsIgnoreCase("erkek")) {
            return new ProcessErkek();
        } else {
            return new ProcessBayan();
        }
    }
    
}
