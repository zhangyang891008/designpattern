package com.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

public class ForkJoinTest {
	public static void main(String[] args) {
		int size = 100000;
		int count = 0;
		double[] arr = new double[size];
		for(int i = 0;i<size;i++) {
			arr[i] = Math.random();
			if(arr[i]>0.5) {
				count++;
			}
		}
		ForkJoinPool pool = new ForkJoinPool();
		Counter counter = new Counter(arr, 0, arr.length, x->x>0.5);
		pool.invoke(counter);
		System.out.println(counter.join());
		System.out.println("verify:"+count);
	}
	
	

}

class Counter extends RecursiveTask<Integer>{
	int threshold = 1000;
	double[] arr ;
	int start;
	int end;
	DoublePredicate filter;
	
	
	public Counter(double[] arr, int start, int end, DoublePredicate filter ) {
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.filter = filter;
	}

	@Override
	protected Integer compute() {
		if(end-start<=threshold) {
			int count=0;
			for(int i = start;i<end;i++) {
				if(filter.test(arr[i])) {
					count++;
				}
			}
			return count;
		}else {
			int mid = start + (end-start)/2;
			Counter first= new Counter(arr, start, mid, filter);
			Counter second = new Counter(arr, mid, end, filter);
			invokeAll(first, second);
			return first.join() + second.join();
		}
	}
	
}