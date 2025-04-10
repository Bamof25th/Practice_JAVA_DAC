package com.app.core;

import java.time.LocalDate;

public class FTE extends Employee {

	private double salByMonth;

	public FTE(String name, String pno, String adharNo, LocalDate doj, double sal) {
		super(name, pno, adharNo, doj);

		this.salByMonth = sal;
	}

	@Override
	public String toString() {
		return "sal= " + salByMonth + " " + super.toString();
	}

	public double getSal() {
		return salByMonth;
	}

	public void setSal(double sal) {
		this.salByMonth = sal;
	}
	
	

}
