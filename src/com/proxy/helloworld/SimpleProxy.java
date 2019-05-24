package com.proxy.helloworld;

public class SimpleProxy extends AbstractEntity{
	AbstractEntity realEntity;
	@Override
	public void print(String str) {
		System.out.println("before...");
		realEntity.print(str);
		System.out.println("after...");
	}
	
	public SimpleProxy(AbstractEntity entity) {
		realEntity = entity;
	}
}
