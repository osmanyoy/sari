package com.training.patterns.abstractfactory;

public class Combined2 implements ICombined {

	@Override
	public IInterface1 getSample() {
		return new Sample2();
	}

	@Override
	public IInterface2 getExample() {
		return new Example2();
	}

}
