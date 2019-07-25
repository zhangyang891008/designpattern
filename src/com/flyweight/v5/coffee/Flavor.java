package com.flyweight.v5.coffee;

public class Flavor extends Order{
	
	String flavor = null;
	
	public Flavor(String flavor) {
		this.flavor = flavor;
	}

	@Override
	void serve() {
		System.out.println("serving->"+flavor);
	}

	@Override
	public String getFlavor() {
		return this.flavor;
	}

}
