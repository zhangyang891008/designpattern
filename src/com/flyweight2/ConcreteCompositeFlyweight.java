package com.flyweight2;

import java.util.HashMap;
import java.util.Iterator;

public class ConcreteCompositeFlyweight extends Flyweight{
	
	private HashMap<Character, Flyweight> files = new HashMap<>();
	
	public void factory(Character state, Flyweight fly) {
		files.put(state,fly);
	}
	
	public void operation(String exState) {
		Flyweight fly = null;
		Iterator<Flyweight> iterator = files.values().iterator();
		while(iterator.hasNext()) {
			fly = iterator.next();
			fly.operation(exState);
		}
	}

}
