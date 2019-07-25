package com.flyweight.v4.complexflyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例工厂模式，生成
 * @author Administrator
 *
 */
public class ComplexSingletonFactory {
	
	Map<Character, FlyWeight> flies = new HashMap<Character, FlyWeight>();
	
	static ComplexSingletonFactory myFactory = new ComplexSingletonFactory();
	
	private ComplexSingletonFactory() {}
	
	public static ComplexSingletonFactory getInstance() {
		return myFactory;
	}
	
	public FlyWeight factory(String innerState) {
		
		ConcreteCompositFlyWeight fly = new ConcreteCompositFlyWeight();
		for (int i = 0; i < innerState.length(); i++) {
			fly.add(new Character(innerState.charAt(i)), factory(innerState.charAt(i)));
		}
		return fly;
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
