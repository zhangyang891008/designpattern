package com.decorator.v1;

public class Decorator implements Component {
	
	private Component component = null;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	public Decorator() {
		 //do something
	}

	@Override
	public void operation() {
		component.operation();
	}

}
