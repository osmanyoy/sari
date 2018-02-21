package com.training.ee.cdi;

import javax.enterprise.inject.Any;

import com.training.ee.model.Person;

@Any
public class ProcessErkek implements IProcess{

    @Override
    public String process(Person person) {
        return "Bay " + person.getIsim();
    }

}
