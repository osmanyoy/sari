package com.training.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.TypedQuery;

import com.training.model.Customer;

/**
 * Session Bean implementation class CustomerDAO
 */
@Stateless
@LocalBean
// @TransactionManagement(TransactionManagementType.BEAN)
public class CustomerDAO {
	
	@PersistenceContext(unitName="newfeature7")
	private EntityManager entityManager;
   
    public CustomerDAO() {
    }
    
    public void insert(Customer customer) {
    	entityManager.persist(customer);
    }
    
    public void insertAll(List<Customer> customers) {
    	for (Customer customer : customers) {
    		entityManager.persist(customer);
		}
    }

    public void update(Customer customer) {
    	entityManager.merge(customer);
    }
    
    public void delete(Customer customer) {
    	Customer mergedCustomer = entityManager.merge(customer);
    	entityManager.remove(mergedCustomer);
    }
    
    public List<Customer> getAllCustomers(){
    	TypedQuery<Customer> createQuery = entityManager.createQuery("select c from Customer c",Customer.class);
    	List<Customer> resultList = createQuery.getResultList();
    	return resultList;
    }

    public List<Customer> getAllCustomerByName(String name){
    	TypedQuery<Customer> createQuery = entityManager.createQuery("select c from Customer c where c.name=:isim",Customer.class);
    	createQuery.setParameter("isim", name);
    	List<Customer> resultList = createQuery.getResultList();
    	return resultList;
    }

}
