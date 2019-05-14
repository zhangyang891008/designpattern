package com.flyweight;

public class SimpleFlyweight extends Flyweight{
	
	Character state;
	
	public SimpleFlyweight(Character state) {
		this.state = state;
	}
	
	@Override
	public void operation(String exState) {
		System.out.println("state:"+state+", some outer operation:"+exState);
	}

}
