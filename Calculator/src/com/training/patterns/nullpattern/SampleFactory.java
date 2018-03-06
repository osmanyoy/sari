package com.training.patterns.nullpattern;

public class SampleFactory {

	public static SampleObjec getObject(final int i) {
		if (i == 1) {
			return new SampleObjec();
		} else {
			return new NullSample();
		}
	}

}
