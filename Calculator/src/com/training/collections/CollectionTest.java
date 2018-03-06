package com.training.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionTest {
	public static void main(String[] args) {
		
	
		List<String> strArrayList = new CopyOnWriteArrayList<>();
		long delta = System.currentTimeMillis();
		for (int i = 0; i < 1_000_000; i++) {
			strArrayList.add("osman" + i);
		}
		System.out.println("Add : " + (System.currentTimeMillis() - delta));
		
		delta = System.currentTimeMillis();
		for (String string : strArrayList) {
			String str = string;
		}
		System.out.println("Process : " + (System.currentTimeMillis() - delta));
		
		
		
//		delta = System.currentTimeMillis();
//		for (int i = 0; i < 1_000_000; i++) {
//			strArrayList.get(i);
//		}
//		System.out.println("Get : " + (System.currentTimeMillis() - delta));

		delta = System.currentTimeMillis();
		for (int i = 0; i < 1_000_000; i++) {
			strArrayList.remove(0);
		}
		System.out.println("Remove : " + (System.currentTimeMillis() - delta));

	}
}
