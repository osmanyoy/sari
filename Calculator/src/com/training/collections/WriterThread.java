package com.training.collections;

import java.util.List;
import java.util.UUID;

public class WriterThread extends Thread{
	private List<String> itSt;
	private int count = 100;
	
	public WriterThread(List<String> itSt) {
		this.itSt = itSt;
		
	}
	@Override
	public void run() {
		while (true) {
			try {
				itSt.add("osman" + count++);
			} catch (Throwable e) {
			}
		}
	}
	
}
