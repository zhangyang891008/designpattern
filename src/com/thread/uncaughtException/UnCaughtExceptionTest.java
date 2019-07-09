package com.thread.uncaughtException;

import java.lang.Thread.UncaughtExceptionHandler;

public class UnCaughtExceptionTest {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				throw new RuntimeException("bye");
			}
		});
		
		thread.setUncaughtExceptionHandler(new MyHandler());
		thread.start();
	}

}

class MyHandler implements UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("I caught the exception");
	}
	
}