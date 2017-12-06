package com.training.ee.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Listener1
 *
 */
@WebListener
public class Listener1 implements ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public Listener1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	@Override
	public void requestDestroyed(final ServletRequestEvent sre) {
		System.out.println("init : " + sre.getServletContext()
		                                  .getContextPath());
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	@Override
	public void requestInitialized(final ServletRequestEvent sre) {
		System.out.println("init : " + sre.getServletContext()
		                                  .getContextPath());
	}

}
