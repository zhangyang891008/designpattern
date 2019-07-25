package com.flyweight.v6.coffeeshop;

public class Client {
	
	static CoffeeFactory coffeeFactory = new CoffeeFactory();
	
	static Order[] orders = new Order[20];
	static int orderCount = 0;
	
	private static void takeOrders(String flavor) {
		orders[orderCount++] = coffeeFactory.get(flavor);
	}
	
	public static void main(String[] args) {
		takeOrders("Black Coffee");
		takeOrders("Capucino");
		takeOrders("Capucino");
		takeOrders("Black Coffee");
		takeOrders("Espresso");
		takeOrders("Capucino");
		
		for(int i = 0;i<orderCount;i++) {
			orders[i].serve(new Table(i));
		}
		
		System.out.println("total:"+orderCount);
	}

}
