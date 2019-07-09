package com.superclass;

public class SuperClass {
	
	String name = "testName";
	public static void main(String[] args) {
		MyClass clazz = new MyClass();
		System.out.println(clazz.getName());;
	}

}
class MyClass extends SuperClass{

	public String getName() {
		return super.name;
	}
	
}