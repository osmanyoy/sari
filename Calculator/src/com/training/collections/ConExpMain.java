package com.training.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConExpMain {
	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("osman"  + i);
		}
		ReaderThread readerThread = new ReaderThread(list);
		readerThread.start();
		WriterThread writerThread = new WriterThread(list);
		writerThread.start();
		try {
			Thread.sleep(10000000L);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
