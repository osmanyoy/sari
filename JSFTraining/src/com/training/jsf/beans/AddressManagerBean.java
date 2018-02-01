package com.training.jsf.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.jsf.dao.CityDAO;
import com.training.jsf.model.City;

@Named
@ApplicationScoped
public class AddressManagerBean {

	@Inject
	private CityDAO cityDAO;
	
	private List<City> cityCache;
	private Map<String,City> cityMap = new HashMap<>();
	
	@PostConstruct
	public void init() {
		cityCache = cityDAO.getCities();
		for (City city : cityCache) {
			cityMap.put(city.getCityName(), city);
		}
	}
	
	public List<City> getCities(){
		return cityCache;
	}

	public City getCity(String city) {
		return cityMap.get(city);
	}
}
