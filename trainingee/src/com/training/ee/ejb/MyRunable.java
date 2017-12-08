package com.training.ee.ejb;

public class MyRunable implements Runnable {
	private static long t = System.currentTimeMillis();

	@Override
	public void run() {
		long l = System.currentTimeMillis() - MyRunable.t;
		if ((l > 6_000) && (l < 9_000)) {
			throw new IllegalAccessError();
		}
		System.out.println("MyRunable executed");
	}

}
