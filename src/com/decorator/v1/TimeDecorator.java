package com.decorator.v1;

public class TimeDecorator extends Decorator {
	
	@Override
	public void operation() {
		System.out.println("start time:"+System.currentTimeMillis());
		super.operation();
		System.out.println("end time:"+System.currentTimeMillis());
	}

	public TimeDecorator() {
		super();
	}
	
	public TimeDecorator(Component component){
		super(component);
	}
	
	
}
