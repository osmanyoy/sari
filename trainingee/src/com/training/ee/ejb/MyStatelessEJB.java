package com.training.ee.ejb;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class MyStatelessEJB {

	@Asynchronous
	public Future<String> myAsyncMethod() {
		try {
			Thread.sleep(10_000);
		} catch (Exception e) {
		}
		return new AsyncResult<String>("test");
	}

}
