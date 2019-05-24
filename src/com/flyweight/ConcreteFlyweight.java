package com.flyweight;

public class ConcreteFlyweight extends Flyweight{

	private Character innerState = null;
	public ConcreteFlyweight(Character state) {
		innerState = state;
	}
	@Override
	public void operation(String state) {
		System.out.println("innerState:"+innerState+
				", ExState:"+state);
	}

}
