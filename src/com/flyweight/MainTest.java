package com.flyweight;

/**
 * 享元模式：单纯享元模式。内蕴模式存储其固有属性通常是字符并存储在服务器端，外蕴模式传递来自客户端参数通常是不同的。
 * @author zhangyang
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		factory.checkMap();
		factory.factory(new Character('a'));
		factory.checkMap();
		factory.factory(new Character('a'));
		factory.checkMap();
		factory.operation("english");
	}

}
