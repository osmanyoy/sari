package com.training.patterns.objectpooling;

public enum EPoolType {
	SMALL(20), MID(50), LARGE(100);

	private int size;

	private EPoolType(final int size) {
		this.size = size;

	}

	public int getSize() {
		return this.size;
	}

}
