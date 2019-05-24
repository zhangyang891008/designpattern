package com.visit;

public class Student extends Customer {
	double price = 0.0;

	@Override
	protected void visitCPU(CPU cpu) {
		price += cpu.price *0.95;
		
	}

	@Override
	protected void visitBoard(Board board) {
		price += board.price *0.9;
		
	}

}
