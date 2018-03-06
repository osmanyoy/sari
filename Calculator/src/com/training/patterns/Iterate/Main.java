package com.training.patterns.Iterate;

public class Main {
	public static void main(String[] args) {
		MyObject myObject = new MyObject();
		myObject.add("osman1");
		myObject.add("osman2");
		myObject.add("osman3");
		for (String string : myObject) {
			System.out.println(string);
		}
		
	}
}
