package com.training.ee.ejb;

import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class SingletonTest
 */
@Singleton
@Startup
@DependsOn({})
@LocalBean
public class SingletonTest {

	/**
	 * Default constructor.
	 */
	public SingletonTest() {
		// TODO Auto-generated constructor stub
	}

}
