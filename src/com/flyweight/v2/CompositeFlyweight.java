package com.flyweight.v2;

import java.util.HashMap;

public class CompositeFlyweight extends Flyweight{
	HashMap<Character,Flyweight> flies = new HashMap<Character, Flyweight>();
	
	public CompositeFlyweight() {
		
	}
	
	public void add(Character state, Flyweight fly) {
		if(flies.containsKey(state)) {
			System.out.println("Character is already exist:"+state.charValue());
		}else {
			flies.put(state, fly);
		}
	}
	
	public void operation(String exState) {
		flies.entrySet().iterator();
		System.out.println();
	}
}
