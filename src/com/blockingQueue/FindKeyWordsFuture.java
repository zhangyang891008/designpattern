package com.blockingQueue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FindKeyWordsFuture {
	
	public static File empty = new File("");
	private static String keyword = "hello";
	
	public static void main(String[] args) {
		try{
			File base = new File("/Users/zy/zydir");
			
			FutureTask<Integer> task = new FutureTask<>(new MyFutureTask(base));
			Thread thread = new Thread(task);
			thread.start();
			try {
				System.out.println(task.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}

		}finally {
			
			
		}
	}
	
	
	public static boolean search(File file) {
		try {
			java.util.Scanner in = new java.util.Scanner(file, "utf8");
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if(line.contains(keyword)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

class MyFutureTask implements Callable<Integer>{
	File file = null;
	int count = 0;
	
	List<FutureTask<Integer>> result = new ArrayList<>();
	public MyFutureTask(File file) {
		this.file = file;
	}

	@Override
	public Integer call() throws Exception {
		File[] files = file.listFiles();
		for(File file:files) {
			if(file.isDirectory()) {
				FutureTask<Integer> task = new FutureTask(new MyFutureTask(file));
				result.add(task);
				task.run();
			}else {
				count += FindKeyWordsFuture.search(file)==true?1:0;
			}
		}
		
		for(FutureTask<Integer> t:result) {
			count+=t.get();
			
		}
		return count;
	}
	
}