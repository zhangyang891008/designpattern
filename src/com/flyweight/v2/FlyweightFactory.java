package com.flyweight.v2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FlyweightFactory {
	
	HashMap<Character, Flyweight> flies = new HashMap<Character, Flyweight>();
	
	public Flyweight factory(Character state) {
		if(flies.containsKey(state)) {
			return flies.get(state);
		}else {
			Flyweight fly = new SimpleFlyweight(state);
			flies.put(state, fly);
			return fly;
		}
	}
	
	public Flyweight factory(String state) {
		CompositeFlyweight compositeFlyweight = new CompositeFlyweight();
		for(int i = 0;i<state.length();i++) {
			Character c = new Character(state.charAt(i));
			compositeFlyweight.add(c, this.factory(c));
		}
		return compositeFlyweight;
	}
	
	public void checkMap() {
		Iterator<Entry<Character, Flyweight>> entry = flies.entrySet().iterator();
		System.out.println("================ start =================");
		while(entry.hasNext()) {
			Entry<Character, Flyweight> e = entry.next();
			System.out.println(e.getKey()+"->"+e.getValue());
		}
		System.out.println("================ end =================");
	}
	
	public void operation(String exState) {
		Iterator<Flyweight> flys = flies.values().iterator();
		while(flys.hasNext()) {
			flys.next().operation(exState);
		}
	}
}
