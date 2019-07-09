package com.enumdemo;

public enum Color {
	Red("r"),Black("b"),Yellow("y");
	String color;
	private Color(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}

}
