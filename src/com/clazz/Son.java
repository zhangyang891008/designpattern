package com.clazz;

public class Son extends Father implements Workable{

	@Override
	public void m1() {
		System.out.println("son m1...");
	}

	@Override
	protected void m3() {
		System.out.println("son m3...");
	}

	@Override
	void m4() {
		System.out.println("son m4...");
	}

}
