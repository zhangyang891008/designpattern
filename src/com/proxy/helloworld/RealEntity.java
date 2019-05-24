package com.proxy.helloworld;

public class RealEntity extends AbstractEntity {

	@Override
	public void print(String str) {
		System.out.println("helloworld:"+str);
	}

}
