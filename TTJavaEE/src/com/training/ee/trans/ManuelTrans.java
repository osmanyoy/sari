package com.training.ee.trans;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.training.ee.model.Person;

@RequestScoped
public class ManuelTrans {
    
    @Resource
    private UserTransaction transaction;
    
    @PersistenceContext(unitName="TTJavaEE")
    private EntityManager entityManager;
    
    
    public void method(Person person) throws NotSupportedException, SystemException {
        transaction.begin();
        try {
            entityManager.joinTransaction();
            entityManager.persist(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
    
}
