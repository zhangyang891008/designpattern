package com.clazz;


public interface Workable {
	default void work() {
		System.out.println("working..");
	}
}
