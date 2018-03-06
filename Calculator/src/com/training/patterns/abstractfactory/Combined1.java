package com.training.patterns.abstractfactory;

public class Combined1 implements ICombined {

	@Override
	public IInterface1 getSample() {
		return new Sample1();
	}

	@Override
	public IInterface2 getExample() {
		return new Example1();
	}

}
