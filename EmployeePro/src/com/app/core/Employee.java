package com.app.core;

import java.time.LocalDate;

public class Employee {
//	 Name, Date of joining, Phone Number, Aadhaar number  
	private int eid;
	private String name;
	private String pno;
	private String adharNo;
	private LocalDate doj;

	public static int count;

	public Employee(String name, String pno, String adharNo, LocalDate doj) {
		this.eid = ++count;
		this.name = name;
		this.pno = pno;
		this.adharNo = adharNo;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [" + "eid" + eid + "name=" + name + ", pno=" + pno + ", adharNo=" + adharNo + ", doj=" + doj
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

}
