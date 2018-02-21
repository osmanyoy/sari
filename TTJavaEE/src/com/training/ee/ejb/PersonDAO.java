package com.training.ee.ejb;

import java.util.Base64;
import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.websocket.RemoteEndpoint.Async;
import javax.ws.rs.container.AsyncResponse;

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
        TypedQuery<Person> createQuery = entityManager.createQuery("select a from Person a where a.name = :isim",
                                                                   Person.class);
        createQuery.setParameter("isim", name);
        return createQuery.getResultList();
    }

    public List<Person> getPersonByName2(String name) {
        TypedQuery<Person> createQuery = entityManager.createNamedQuery("select_by_name",
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

    public List<Person> getPersonByName3(String name) {
        TypedQuery<Person> createQuery = entityManager.createNamedQuery("select_by_name_native",
                                                                   Person.class);
        createQuery.setParameter("isim", name);
        return createQuery.getResultList();
    }
    
    public void test() {
        String encodeToString = Base64.getEncoder().encodeToString("osman12".getBytes());
        String raw = new String(Base64.getDecoder().decode(encodeToString));
        
    }
    
    @Asynchronous
    public Future<Person> findPerson(long personId){
        return new AsyncResult<Person>( entityManager.find(Person.class, personId));
    }

}
