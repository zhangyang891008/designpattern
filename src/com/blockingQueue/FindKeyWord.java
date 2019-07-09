package com.blockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class FindKeyWord {
	
	public static void main(String[] args) {
		File file = new File("/Users/zy/zydir");
		String keyword = "hello";
		FutureTask<Integer> task = new FutureTask<>(new Count(file, keyword));
		Thread thread = new Thread(task);
		thread.start();
		try {
			System.out.println(task.get());;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
	}

}

class Count implements Callable<Integer>{

	String keyword = null;
	File file = null;
	int count = 0;
	public Count(File file, String keyword) {
		this.file = file;
		this.keyword = keyword;
	}

	@Override
	public Integer call() throws Exception {
		List<FutureTask<Integer>> result = new ArrayList<>();
		File[] files = file.listFiles();
		for(File f:files) {
			if(f.isDirectory()) {
				FutureTask<Integer> task = new FutureTask<>(new Count(file, keyword));
				result.add(task);
				Thread thread = new Thread(task);
				thread.start();
			}else {
				if(search(f,keyword)) {
					count +=1;
				}
			}
		}
		
		for(FutureTask<Integer> task:result) {
			count+= task.get();
		}
		
		return count;
		
	}
	
	private static boolean search(File file, String keyword) {
		Scanner in;
		try {
			in = new Scanner(file,"utf8");
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if(line.contains(keyword)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}