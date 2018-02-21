package com.training.ee.interceptor;

import com.training.ee.model.Person;

@NewAnnotation
public class TestConstructorInterceptor {
    
    public TestConstructorInterceptor() {
        System.out.println("Construct Test");
    }
    
    private Person person;
    private String id;
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
