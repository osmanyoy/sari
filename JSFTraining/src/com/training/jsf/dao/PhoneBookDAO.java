package com.training.jsf.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.training.jsf.model.Customer;
import com.training.jsf.model.PhoneBookItem;

@Stateless
@LocalBean
public class PhoneBookDAO {
    @PersistenceContext(unitName="JSFTraining")
	private EntityManager entityManager;
	/**
     * Default constructor. 
     */
    public PhoneBookDAO() {
    }
    
    public boolean savePhoneEntry(PhoneBookItem bookItem) {
    	if (!entityManager.contains(bookItem.getCustomer())) {
    		Customer merge = entityManager.merge(bookItem.getCustomer());
    		bookItem.setCustomer(merge);
    	}
    	entityManager.persist(bookItem);
    	return true;
    }
    
    public List<PhoneBookItem> getPhoneBook(){
    	TypedQuery<PhoneBookItem> createQuery = entityManager.createQuery("select p from PhoneBookItem p",PhoneBookItem.class);
    	List<PhoneBookItem> resultList = createQuery.getResultList();
    	return resultList;
    }
    
	public void deletePhoneEntry(PhoneBookItem bookItem) {
		PhoneBookItem mergedPhoneItem = entityManager.merge(bookItem);
		entityManager.remove(mergedPhoneItem);
	}

	public void updatePhoneEntry(PhoneBookItem bookItem) {
		entityManager.merge(bookItem);
	}
	
}
