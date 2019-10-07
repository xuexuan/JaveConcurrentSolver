package com.test.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class SequencePrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("helloworld");
		AtomicInteger ai = new AtomicInteger(1);
		Thread t1 = new Thread(new SequenceList(ai, true));
		Thread t2 = new Thread(new SequenceList(ai, false));
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
