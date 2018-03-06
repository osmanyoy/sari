package com.training.patterns.abstractfactory;

public class SampleFactory {
	public static IInterface1 createSample(final int i) {
		switch (i) {
		case 1:
			return new Sample1();
		case 2:
			return new Sample2();

		default:
			return new Sample1();
		}
	}

	public static IInterface2 createExample(final int i) {
		switch (i) {
		case 1:
			return new Example1();
		case 2:
			return new Example2();

		default:
			return new Example1();
		}
	}

}
