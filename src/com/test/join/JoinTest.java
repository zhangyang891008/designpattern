package com.test.join;

public class JoinTest {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
					System.out.println("finish...");
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("sleep interrupt...");
				}
			}
		});
		thread.start();
		try {
			thread.join(2000);
			System.out.println("join finish...");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("join...");
		}
	}

}
