package com.training.patterns.creational.singleton;

public class SingletonMain {
	public static void main(String[] args) {
		Singleton.getInstance()
		         .hello();
		ESingleton.INSTANCE1.hello();
		ESingleton.INSTANCE2.hello();
		
		String exec = ESingleton.INSTANCE1.exec();
		System.out.println(exec);
	}
	
	public String myMethod(String str) {
		if (str != null) {
			if (str.startsWith("osm")) {
				return "osman";
			}
		}
		return null;
	}

	public String myMethod2(String str) {
		if (str == null) {
			return null;
		}
		if (str.startsWith("osm")) {
			return "osman";
		}
		return null;
	}

	public String myMethod3(String str) {
		String retVal = null;
		if (str == null) {
			retVal =null;
		} else if (str.startsWith("osm")) {
			retVal = "osman";
		}
		return retVal;
	}

	public String myMethod4(String str) {
		String retVal = null;
		if (str != null && str.startsWith("osm")) {
			retVal = "osman";
		}
		return retVal;
	}

}
