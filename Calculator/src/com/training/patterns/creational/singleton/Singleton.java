package com.training.patterns.creational.singleton;

public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public void hello() {
		System.out.println("Hello World");
	}
}
