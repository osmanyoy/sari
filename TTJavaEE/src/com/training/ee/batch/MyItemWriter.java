package com.training.ee.batch;

import java.util.List;

import javax.annotation.Resource;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.w3c.dom.css.Counter;

@Named("mywriter")
public class MyItemWriter extends AbstractItemWriter{
    
    @PersistenceContext(unitName="TTJavaEE")
    private EntityManager em;
    
    @Override
    public void writeItems(List<Object> items) throws Exception {
            // em.joinTransaction();
            for (Object object : items) {
                Employee employee = (Employee) object;
                em.persist(employee);
            }
    }

}
