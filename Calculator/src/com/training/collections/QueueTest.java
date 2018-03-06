package com.training.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {
	public static void main(final String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
		queue.add("osman1");

		String take = queue.take();

		String poll = queue.poll();

	}
}
