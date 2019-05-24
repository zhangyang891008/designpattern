package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler{
	Object obj;
	
	public MyProxy(Object o) {
		obj = o;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass().getName());
		 try {
			System.out.println("before invoke......");
			 Object object =method.invoke(obj, args);
			System.out.println("after invoke......");
			 return object;
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return args;
	}
	
	public static Object factory(Object obj) {
		Class clazz = obj.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new MyProxy(obj));
	}
	
	public static void main(String[] args) {
		ISomeService service = (ISomeService) factory(new SomeService());
		System.out.println(service.getClass().getName());
		service.print("test");
		//System.out.println("");
	}
	

}
