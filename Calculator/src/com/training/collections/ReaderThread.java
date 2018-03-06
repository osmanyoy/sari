package com.training.collections;

import java.util.Iterator;
import java.util.List;

public class ReaderThread extends Thread{
	private List<String> itSt;
	
	public ReaderThread(List<String> itSt) {
		this.itSt = itSt;
		
	}
	@Override
	public void run() {
		while (true) {
			try {
				for (String str : itSt) {
					System.out.println(str);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
}
