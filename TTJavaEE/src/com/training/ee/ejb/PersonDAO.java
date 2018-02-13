package com.training.ee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.training.ee.model.Person;

/**
 * Session Bean implementation class PersonDAO
 */
@Stateless
@LocalBean
public class PersonDAO {

    @PersistenceContext(unitName = "TTJavaEE")
    private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public PersonDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public int getId() {
        return 0;
    }
    
    public void save(Person person) {
        entityManager.persist(person);
    }

}
