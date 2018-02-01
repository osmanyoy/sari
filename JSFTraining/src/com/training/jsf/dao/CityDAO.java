package com.training.jsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.training.jsf.model.City;
import com.training.jsf.model.PhoneBookItem;

public class CityDAO {
    @PersistenceContext(unitName="JSFTraining")
	private EntityManager entityManager;
    public CityDAO() {
    }
    
    public List<City> getCities(){
    	TypedQuery<City> createQuery = entityManager.createQuery("select p from City p",City.class);
    	List<City> resultList = createQuery.getResultList();
    	return resultList;
    }
    
}
