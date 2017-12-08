package com.training.ee.ejb;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.training.ee.model.Employee;

@Path("ejb")
public class EJBTest {

	@EJB
	private SingletonTest st;

	@EJB
	private MyStatelessEJB ms;

	@Resource
	// @Resource(lookup = "DefaultManagedExecutorsService")
	private ManagedExecutorService mes;

	@Resource
	// @Resource(lookup = "DefaultManagedExecutorsService")
	private ManagedScheduledExecutorService mses;

	@GET
	public String name1() {
		return this.st.test1();
	}

	@GET
	@Path("t2")
	public String name2() {
		return this.st.test2();
	}

	@GET
	@Path("t3")
	public String name3() {
		return this.st.test3();
	}

	@GET
	@Path("t4")
	public String name4() {
		Future<String> myAsyncMethod = this.ms.myAsyncMethod();
		System.out.println("I am working");

		try {
			while (!myAsyncMethod.isDone()) {
				System.out.println("I am still working");
				Thread.sleep(1000);
			}
			return myAsyncMethod.get();
		} catch (InterruptedException | ExecutionException e) {
		}
		return null;
	}

	@GET
	@Path("t5")
	@Produces(MediaType.APPLICATION_XML)
	public Employee name5() {
		Future<Employee> myAsyncMethod = this.mes.submit(new MyCallable());
		System.out.println("I am working");
		try {
			while (!myAsyncMethod.isDone()) {
				System.out.println("I am still working");
				Thread.sleep(1000);
			}
			return myAsyncMethod.get();
		} catch (InterruptedException | ExecutionException e) {
		}
		return null;
	}

	@GET
	@Path("t6")
	@Produces(MediaType.APPLICATION_XML)
	public String name6() {
		this.mses.scheduleWithFixedDelay(new MyRunable(),
		                                 1_000,
		                                 2_000,
		                                 TimeUnit.MILLISECONDS);
		return "OK";
	}

}
