package com.decorator.v1;

/**
 * 装饰模式
 * @author Administrator
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
		Component component = new TimeDecorator(new LogDecorator(new ConcreteComponent()));
		component.operation();
	}

}
