package com.training.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MyFirstStatelessEJB
 */
@Stateless
@LocalBean
public class MyFirstStatelessEJB {

    private int counter = 0;
	/**
     * Default constructor. 
     */
    public MyFirstStatelessEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public String hello() {
    	return "hello " + counter++;
    }

}
