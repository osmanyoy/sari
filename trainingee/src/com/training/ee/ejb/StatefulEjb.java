package com.training.ee.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class StatefulEjb
 */
@Stateful
@LocalBean
public class StatefulEjb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6282335298273928268L;

	/**
	 * Default constructor.
	 */
	public StatefulEjb() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

	}

	@PreDestroy
	public void desty() {

	}

	@PrePassivate
	public void pasif() {

	}

	@PostActivate
	public void aktif() {

	}

	@Remove
	public void remove() {

	}

}
