package com.enumdemo;

import java.util.Arrays;

public class EnumTest {
	
	public static void main(String[] args) {
		//toString
		String ret = Color.Red.toString();
		System.out.println(ret);
		
		//
		Color red = Enum.valueOf(Color.class, ret);
		
		Color[] colors = Color.values();
		int pos = Color.Black.ordinal();
		System.out.println(pos);
		
		Color[] arr = new Color[3];
		arr[0] = Color.Black;
		arr[1] = Color.Red;
		arr[2] = Color.Yellow;
		Arrays.sort(arr);
		System.out.println("hello");
	}

}
