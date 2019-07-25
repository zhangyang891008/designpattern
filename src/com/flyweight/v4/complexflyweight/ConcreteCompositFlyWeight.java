package com.flyweight.v4.complexflyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元模式
 * @author Administrator
 *
 */
public class ConcreteCompositFlyWeight implements FlyWeight{
	
	Map<Character, FlyWeight> flies = new HashMap<Character, FlyWeight>();
	
	public void add(Character ch, FlyWeight fly) {
		flies.put(ch, fly);
	}

	@Override
	public void operate(String outState) {
		System.out.println("******check*******");
		for(Character c: flies.keySet()) {
			System.out.println("**"+c.charValue()+","+outState);
		}
	}

}
