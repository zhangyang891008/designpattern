package com.flyweight.v6.coffeeshop;

public class Flavor extends Order{
	
	String flavor = null;
	
	public Flavor(String flavor) {
		this.flavor = flavor;
	}

	@Override
	void serve(Table table) {
		System.out.println("table:"+table.getNumber() +", serving->"+flavor);
	}

	@Override
	public String getFlavor() {
		return this.flavor;
	}

}
