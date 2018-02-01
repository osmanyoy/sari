package com.training.jsf.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.training.jsf.model.Customer;
import com.training.jsf.model.PhoneBookItem;

/**
 * Session Bean implementation class CustomerDAO
 */
@Stateless
@LocalBean
public class CustomerDAO {

    @PersistenceContext(unitName="JSFTraining")
	private EntityManager entityManager;
	/**
     * Default constructor. 
     */
    public CustomerDAO() {
    }
    
    public boolean saveCustomer(Customer customer) {
    	entityManager.persist(customer);
    	return true;
    }
    
    public List<Customer> getAllCustomers(){
    	TypedQuery<Customer> createQuery = entityManager.createQuery("select c from Customer c",Customer.class);
    	List<Customer> resultList = createQuery.getResultList();
    	return resultList;
    }
    
    public Customer getCustomer(String username,String password) {
    	TypedQuery<Customer> createQuery = entityManager.createQuery("select c from Customer c where c.name=:isim and c.surname=:soyad",Customer.class);
    	createQuery.setParameter("isim", username);
    	createQuery.setParameter("soyad", password);
    	List<Customer> resultList = createQuery.getResultList();
    	if (resultList.size() > 0) {
    		return resultList.get(0);
    	}
    	return null;
    	
    }

	public void deleteCustomer(Customer customer) {
		Customer mergedCustomer = entityManager.merge(customer);
		entityManager.remove(mergedCustomer);
	}

	public void updateCustomer(Customer customer) {
		entityManager.merge(customer);
	}
	
	public List<PhoneBookItem> getAllPhoneList(Customer customer){
		Customer mergedCustomer = entityManager.merge(customer);
		return mergedCustomer.getPhonebook();
	}

}
