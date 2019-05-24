package com.visit;

public class Computer {
	
	CPU cpu = null;
	Board board = null;
	
	public Computer(CPU cpu,Board board) {
		this.cpu = cpu;
		this.board = board;
	}
	
	public void buyCPU() {
		cpu.operateCPU();
	}
	
	public void buyBoard() {
		board.operateBoard();
	}
	
	public void combine() {
		buyBoard();
		buyCPU();
	}
}
