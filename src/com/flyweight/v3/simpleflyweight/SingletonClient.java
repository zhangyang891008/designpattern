package com.flyweight.v3.simpleflyweight;

public class SingletonClient {
	
	public static void main(String[] args) {
		SingletonFactory factory = SingletonFactory.getInstance();
		FlyWeight fly = factory.factory(new Character('a'));
		fly.operate("hello");
		FlyWeight fly2 = factory.factory(new Character('b'));
		fly2.operate("bye");
		FlyWeight fly3 = factory.factory(new Character('a'));
		fly3.operate("test");
		factory.check();
	}

}
