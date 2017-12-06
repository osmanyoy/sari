package com.training.ee.ejb;

public class JavaSingleton {
	private volatile static JavaSingleton instance;

	private JavaSingleton() {

	}

	public static JavaSingleton getInstance() {
		if (JavaSingleton.instance == null) {
			synchronized (JavaSingleton.class) {
				if (JavaSingleton.instance == null) {
					JavaSingleton.instance = new JavaSingleton();
				}
			}
		}
		return JavaSingleton.instance;
	}
}
