package com.test.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceList implements Runnable{

	private int _count;
	private AtomicInteger _ai;// = new AtomicInteger(1);
	private Boolean _isOdd;
	
	public SequenceList(AtomicInteger ai_, Boolean isOdd_)
	{
		_ai = ai_;
		_count = 1;
		_isOdd = isOdd_;
	}
	
	public void run() 
	{
		while (_count < 11)
		{
			if (_isOdd ^ _count % 2 != 0)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(_count);
			_count = _ai.incrementAndGet();
			notify();
		}
	}
}

