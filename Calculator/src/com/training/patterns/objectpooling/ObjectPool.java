package com.training.patterns.objectpooling;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ObjectPool {
	private static final int POOL_SIZE = 100;

	private BlockingQueue<MyObject> pool = new ArrayBlockingQueue<>(ObjectPool.POOL_SIZE);

	public ObjectPool() {
		this.createPool(ObjectPool.POOL_SIZE);
	}

	public ObjectPool(final EPoolType poolType) {
		this.createPool(poolType.getSize());

	}

	private void createPool(final int size) {
		for (int i = 0; i < size; i++) {
			MyObject myObject = new MyObject(this);
			this.pool.add(myObject);
		}
	}

	public void close(final MyObject myObject) {
		this.pool.add(myObject);
	}

	public MyObject get() {
		try {
			return this.pool.take();
		} catch (Exception e) {
			return null;
		}
	}
}
