package com.training.patterns.nullpattern;

public class SampleRun {
	public static void main(final String[] args) {
		SampleObjec objec = SampleFactory.getObject(1);
		String process = objec.process("dhdhd");
		if (process.startsWith("aabbcc")) {
			// do smth
		}
	}

}
