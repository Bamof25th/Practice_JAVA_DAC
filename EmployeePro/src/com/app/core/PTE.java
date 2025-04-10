package com.app.core;

import java.time.LocalDate;

public class PTE extends Employee {

	private double salPerHrs;

	public PTE(String name, String pno, String adharNo, LocalDate doj, double sal) {
		super(name, pno, adharNo, doj);

		this.salPerHrs = sal;
	}

	@Override
	public String toString() {
		return "sal= " + salPerHrs + " " + super.toString();
	}

	public double getSal() {
		return salPerHrs;
	}

	public void setSal(double sal) {
		this.salPerHrs = sal;
	}

}
