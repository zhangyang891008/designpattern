package com.flyweight.v2;

/**
 * 享元模式：复合享元模式。复合享元对象不能共享，分解的单纯享元对象课可以共享。
 * 1复合享元对象有单纯的享元对象通过复合而成，这些聚集元素是在复合享元对象创建后才加入进来的，所以对象的状态会变化，不能共享。
 * 2一个复合享元对象中所有的单纯享元对象的外蕴状态都是相等的，但是内蕴对象都是不相等的。
 * @author zhangyang
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		factory.checkMap();
		factory.factory("abcdabc");
		factory.checkMap();
	}

}
