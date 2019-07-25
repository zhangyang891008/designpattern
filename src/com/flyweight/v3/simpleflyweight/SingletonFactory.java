package com.flyweight.v3.simpleflyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例工厂模式，生成
 * @author Administrator
 *
 */
public class SingletonFactory {
	
	Map<Character, FlyWeight> flies = new HashMap<Character, FlyWeight>();
	
	static SingletonFactory myFactory = new SingletonFactory();
	
	private SingletonFactory() {}
	
	public static SingletonFactory getInstance() {
		return myFactory;
	}
	
	public FlyWeight factory(Character innerState) {
		if(flies.get(innerState)!=null) {
			return flies.get(innerState);
		}else {
			ConcreteFlyWeight flyWeight = new ConcreteFlyWeight(innerState);
			flies.put(innerState, flyWeight);
			return flyWeight;
		}
		
	}
	
	public void check() {
		System.out.println("***check***");
		for(Character c: flies.keySet()) {
			System.out.println("**"+c);
		}
	}

}
