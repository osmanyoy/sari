package com.training.ee.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.PrePersist;

import com.training.ee.model.Person;

@Stateful
@LocalBean
public class StatefulEJB implements Serializable{

    @EJB
    private PersonDAO personDAO;
    
    public StatefulEJB() {
    }
    
    @PostConstruct
    public void init() {
        Person person = new Person();
        personDAO.save(person);
        
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("StatefulEJB destroyed");
    }
    
    @PrePassivate
    public void persistBefore() {
        
    }
    
    @PostActivate
    public void persistAfter() {
        
    }
    
    @Remove
    public void destroyEJB() {
        System.out.println("EJB remove");
    }
    
}
