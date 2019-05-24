package com.proxy;

public class SomeService implements ISomeService {

	@Override
	public void print(String str) {
		System.out.println("someservice:"+str);
	}

}
