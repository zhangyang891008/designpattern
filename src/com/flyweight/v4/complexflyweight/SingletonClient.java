package com.flyweight.v4.complexflyweight;

public class SingletonClient {
	
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	public static void test2() {
		ComplexSingletonFactory factory =ComplexSingletonFactory.getInstance();
		FlyWeight fly = factory.factory("cabcc");
		fly.operate("hello");
		factory.check();
	}
	
	public static void test1() {
		ComplexSingletonFactory factory = ComplexSingletonFactory.getInstance();
		FlyWeight fly = factory.factory(new Character('a'));
		fly.operate("hello");
		FlyWeight fly2 = factory.factory(new Character('b'));
		fly2.operate("bye");
		FlyWeight fly3 = factory.factory(new Character('a'));
		fly3.operate("test");
		factory.check();
	}

}
