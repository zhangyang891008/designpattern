package com.flyweight;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FlyweightFactory {
	
	HashMap<Character, Flyweight> files = new HashMap<Character, Flyweight>();
	
	public Flyweight factory(Character state) {
		if(files.containsKey(state)) {
			return files.get(state);
		}else {
			Flyweight fly = new SimpleFlyweight(state);
			files.put(state, fly);
			return fly;
		}
	}
	
	public void checkMap() {
		Iterator<Entry<Character, Flyweight>> entry = files.entrySet().iterator();
		System.out.println("================ start =================");
		while(entry.hasNext()) {
			Entry<Character, Flyweight> e = entry.next();
			System.out.println(e.getKey()+"->"+e.getValue());
		}
		System.out.println("================ end =================");
	}
	
	public void operation(String exState) {
		Iterator<Flyweight> flys = files.values().iterator();
		while(flys.hasNext()) {
			flys.next().operation(exState);
		}
	}
}
