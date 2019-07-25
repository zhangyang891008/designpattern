package com.flyweight.v5.coffee;

/**
 * 只有内蕴状态没有外蕴状态的例子
 * @author Administrator
 *
 */
public class CoffeeFactory {
	
	private static Order[] flavors = new Order[10];
	private int flavorSize = 0;
	private int orderSize = 0;
	
	public Order get(String flavor) {
		
		if(flavorSize>0) {
			for(int i = 0;i<orderSize;i++) {
				if(flavor.equals(flavors[i].getFlavor())) {
					return flavors[i];
				}
			}
		}
		
		System.out.println("***need to produce:"+flavor);
		Flavor flavorNew = new Flavor(flavor);
		flavors[orderSize++] = flavorNew;
		flavorSize++;
		
		return flavorNew;
	}

}
