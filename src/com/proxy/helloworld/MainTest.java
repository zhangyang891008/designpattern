package com.proxy.helloworld;

public class MainTest {
	public static void main(String[] args) {
		AbstractEntity realEntity = new SimpleProxy(new RealEntity());
		realEntity.print("hello");
	}
}
