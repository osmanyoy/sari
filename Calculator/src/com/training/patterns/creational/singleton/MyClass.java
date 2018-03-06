package com.training.patterns.creational.singleton;

public class MyClass implements IMyInterface {

	@Override
	public String method(String str) {
		if (str.startsWith("ttt")) {
			throw new IllegalArgumentException("olmaz");
		}
		return "Hello : " + str;
	}

	@Override
	public ReturnValue method(InputValue val) {
		if (val.getIntputStr().startsWith("ttt")) {
			return new ReturnValue().setStr("Hello").setErrorOccurred(true);
		}
		return new ReturnValue().setStr("Hello");
	}

}
