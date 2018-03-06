package com.training.patterns.abstractfactory;

public class AbstractFactory {
	public static ICombined getCombined(final int i) {
		switch (i) {
		case 1:
			return new Combined1();
		case 2:
			return new Combined2();

		default:
			return new Combined1();
		}
	}
}
