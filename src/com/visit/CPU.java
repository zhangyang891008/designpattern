package com.visit;

public class CPU {
	Customer customer;
	
	double price = 1000;
	
	public CPU(Customer customer) {
		this.customer = customer;
	}
	
	public void operateCPU() {
		customer.visitCPU(this);
	}
}
