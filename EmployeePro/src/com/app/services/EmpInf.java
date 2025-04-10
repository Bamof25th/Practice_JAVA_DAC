package com.app.services;

import java.time.LocalDate;

import com.app.exce.AllException;

public interface EmpInf {
	/*
	 * Application Menu: Add full time employee Add part time employee Delete an
	 * employee by Emp Id Search employee details by Aadhaar number Display all
	 * employee details Display all employee details sorted by date of joining Exit
	 */

	void addFTEmployee(String name, String pno, String adharNo, String doj, double sal) throws AllException;

	void addPTEmployee(String name, String pno, String adharNo, String doj, double sal) throws AllException;

	void deleteEmp(int cid) throws AllException;

	void getEmpByAdharNo(String adhno) throws AllException;

	void getAllEmp() ;

	void getEmpSortedByDoj();

}
