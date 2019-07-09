package com.atomic;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorTest {
	
	public static void main(String[] args) {
		int size = 20;
		CountDownLatch countDownLatch = new CountDownLatch(size);
		LongAccumulator accumulator = new LongAccumulator(Math::max, 0);
		for(int i = 0;i<size;i++) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					int num = new Random().nextInt(100);
					accumulator.accumulate(num);
					System.out.println("add:"+num);
					countDownLatch.countDown();
				}
			});
			thread.start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(accumulator.get());
	}

}
