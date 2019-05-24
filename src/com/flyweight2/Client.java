package com.flyweight2;

/**
 * 享元模式：复合享元模式中，复合享元对象不能共享，但是可以分解成可以共享的单纯享元对象。
 * @author zy
 *
 */
public class Client {
	
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight fly = factory.factory("abcdb");
		fly.operation("call");
		factory.checkFlyweight();
	}

}
