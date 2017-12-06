package com.training.ee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Hello
 */
@Stateless
@LocalBean
public class Hello {

	public Hello() {

	}

	public String helloMsg(final String msg) {
		return "Hello " + msg;

	}

	public String prevMsg() {
		return "prev";
	}

}
