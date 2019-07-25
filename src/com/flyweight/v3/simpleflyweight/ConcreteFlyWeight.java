package com.flyweight.v3.simpleflyweight;

public class ConcreteFlyWeight implements FlyWeight{
	Character innerState = null;
	
	public ConcreteFlyWeight(Character innerState) {
		this.innerState = innerState;
	}

	@Override
	public void operate(String outState) {
		System.out.println("outState :"+ outState+" ,operate on innerState:"+innerState);
	}

}
