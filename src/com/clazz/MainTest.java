package com.clazz;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
	
	public static void main(String[] args) {
		
		List<String> aList = new ArrayList<>();
		Son son = new Son();
		Method[] methods = son.getClass().getMethods();
		for(Method method:methods) {
			StringBuilder stringBuilder = new StringBuilder();
			
			String modifier = Modifier.toString(method.getModifiers());
			stringBuilder.append(modifier);
			stringBuilder.append(" "+method.getName()+"()");
			System.out.println(stringBuilder);
		}
	}

}
