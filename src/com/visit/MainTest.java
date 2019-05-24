package com.visit;
/**
 * vistor模式
 * @author zy
 *
 */

public class MainTest {
	
	public static void main(String[] args) {
		Student student = new Student();
		Computer computer = new Computer(new CPU(student), new Board(student));
		computer.combine();
		
		Worker worker = new Worker();
		Computer computer1 = new Computer(new CPU(worker), new Board(worker));
		computer1.combine();
		
		System.out.println(student.price);
		System.out.println(worker.price);
	}

}
