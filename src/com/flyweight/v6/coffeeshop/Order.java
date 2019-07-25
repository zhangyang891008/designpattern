package com.flyweight.v6.coffeeshop;

public abstract class Order {
	
	abstract void serve(Table table);
	public abstract String getFlavor();
}
