package com.training.patterns.abstractfactory;

public class AbstractFactoryRun {
	public static void main(final String[] args) {
		// Factory
		IInterface2 createExample = SampleFactory.createExample(1);
		IInterface1 createSample = SampleFactory.createSample(1);

		// AbstractFactory
		ICombined combined = AbstractFactory.getCombined(1);

		IInterface1 sample = combined.getSample();
		IInterface2 example = combined.getExample();

	}
}
