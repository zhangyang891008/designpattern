package com.visit;

public class Board {
	Customer customer;
	double price = 2000;
	
	public Board(Customer customer) {
		this.customer = customer;
	}
	
	public void operateBoard(){
		customer.visitBoard(this);
	}

}
