package com.decorator.v1;

public class ConcreteComponent implements Component{

	@Override
	public void operation() {
		System.out.println("do concrete operation... ...");
	}

}
