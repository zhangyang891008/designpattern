package com.flyweight;

/**
 * 享元模式：单纯享元模式中，享元对象都是可以共享的。
 * @author zy
 *
 */
public class Client {
	
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		factory.factory(new Character('a'));
		factory.factory(new Character('b'));
		factory.factory(new Character('b'));
		factory.checkFlyweight();
	}

}
