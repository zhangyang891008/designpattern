package com.flyweight;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FlyweightFactory {
	private HashMap<Character, Flyweight> files = new HashMap<>();
	
	public FlyweightFactory() {}
	
	public Flyweight factory(Character c) {
		if(files.containsKey(c)) {
			return files.get(c);
		}else {
			Flyweight flyweight = new ConcreteFlyweight(c);
			files.put(c, flyweight);
			return flyweight;
		}
	}
	
	public void checkFlyweight() {
		System.out.println("==========check() begin===========");
		Iterator<Entry<Character, Flyweight>> iterator = files.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Character, Flyweight> entry = iterator.next();
			System.out.println(entry.getKey());
		}
		System.out.println("==========check() end=============");
	}

}
