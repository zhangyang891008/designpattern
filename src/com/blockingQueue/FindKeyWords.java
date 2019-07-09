package com.blockingQueue;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FindKeyWords {
	
	private static File empty = new File("");
	private static int SEARCH_THREAD = 10;
	private static BlockingQueue<File> queue = new LinkedBlockingQueue<>();
	private static String keyword = "hello";
	
	public static void main(String[] args) {
		try{
			File base = new File("/Users/zy");
			Thread listFileThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					listFiles(base);
					try {
						queue.put(empty);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			listFileThread.start();
			
			for(int i = 0;i<SEARCH_THREAD;i++) {
				Thread searchThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						boolean done = false;
						while(!done) {
							File file;
							try {
								file = queue.take();
								if(file == empty) {
									queue.put(file);
									done = true;
								}else {
									search(file);
								}
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}
					}
				});
			searchThread.start();
			}
		}finally {
			
			
		}
	}
	
	public static void listFiles(File base) {
		File[] files = base.listFiles();
		for(File file:files) {
			try {
				if(file.isDirectory()) {
					listFiles(file);
				}else {
					queue.put(file);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void search(File file) {
		try {
			java.util.Scanner in = new java.util.Scanner(file, "utf8");
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if(line.contains(keyword)) {
					System.out.println("#"+file.getAbsoluteFile());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
