package com.training.ee.cdi;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.training.ee.interceptor.NewAnnotation;
import com.training.ee.model.Person;

@SessionScoped
@NewAnnotation
public class PersonHolder implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 4655984099980181013L;
    private Person person;
    private String id;
    
    public PersonHolder() {
        System.out.println("test");
    }
    
    public PersonHolder(PersonHolder holder) {
        this.person = holder.getPerson();
        this.id = holder.getId();
    }

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
