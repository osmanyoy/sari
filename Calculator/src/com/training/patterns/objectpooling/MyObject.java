package com.training.patterns.objectpooling;

import java.io.Closeable;
import java.io.IOException;

public class MyObject implements Closeable {

	private ObjectPool objectPool;

	public MyObject(final ObjectPool objectPool) {
		this.objectPool = objectPool;
	}

	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public void close() throws IOException {
		this.objectPool.close(this);
	}

}
