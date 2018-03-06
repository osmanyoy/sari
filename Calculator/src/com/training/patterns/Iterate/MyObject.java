package com.training.patterns.Iterate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyObject implements Iterable<String>{
	
	private String name;
	private List<String> strArray = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void add(String str) {
		strArray.add(str);
	}
	
	public boolean get(String str) {
		return strArray.contains(str);
	}
	
	@Override
	public Iterator<String> iterator() {
		return new MyIterator(this);
	}
	
	public static class MyIterator implements Iterator<String>{
		
		private MyObject myObject;
		private int index = 0;

		public MyIterator(MyObject myObject) {
			this.myObject = myObject;
		}

		@Override
		public boolean hasNext() {
			return this.myObject.strArray.size() - index > 0;
		}

		@Override
		public String next() {
			return this.myObject.strArray.get(index++);
		}
		
	}
	
}
