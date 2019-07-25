package com.decorator.v1;

public class LogDecorator extends Decorator{
	
	public LogDecorator(Component component) {
		super(component);
	}
	
	public LogDecorator() {
		super();
	}
	
	@Override
	public void operation() {
		System.out.println("invoke method...");
		super.operation();
		System.out.println("invoke finish...");
	}

}
