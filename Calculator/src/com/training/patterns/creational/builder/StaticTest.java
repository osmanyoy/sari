package com.training.patterns.creational.builder;

public class StaticTest {
	public static String test;
	
	static {
		test = "osman";
		for (int i = 0; i < 100; i++) {
			test += " i : " + i;
		}
	}
	
}
