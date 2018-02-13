package com.training.ee.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    public List<Person> getPersonByName(String name) {
        TypedQuery<Person> createQuery = entityManager.createQuery("select a from Person where a.name = :isim",
                                                                   Person.class);
        createQuery.setParameter("isim", name);
        return createQuery.getResultList();
    }

    public List<Person> getPersonByNameNative(String name) {
        Query createNativeQuery = entityManager.createNativeQuery("Select * from persontable where name = :isim ",
                                                                         Person.class);
        createNativeQuery.setParameter("isim", name);
        return createNativeQuery.getResultList();
    }

}
