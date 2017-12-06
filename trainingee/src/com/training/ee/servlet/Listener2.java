package com.training.ee.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener2
 *
 */
@WebListener
public class Listener2 implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public Listener2() {
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(final HttpSessionEvent se) {
		System.out.println("Session Created : " + se.getSession()
		                                            .getId());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(final HttpSessionEvent se) {
		System.out.println("Session Destroy : " + se.getSession()
		                                            .getId());
	}

}
