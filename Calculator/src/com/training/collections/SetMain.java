package com.training.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {
	public static void main(String[] args) {
		Set<String> set1 = new TreeSet<>();
		set1.add("osman1");
		set1.add("osman2");
		set1.add("osman3");
		set1.add("osman4");
		set1.add("osman5");
		set1.add("osman5");
		
		Set<String> set2 = new TreeSet<>();
		set2.add("osman3");
		set2.add("osman4");
		set2.add("osman6");
		
		set1.addAll(set2);
		

		System.out.println(set1);
		
	}
}
