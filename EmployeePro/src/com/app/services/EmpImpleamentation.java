package com.app.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Employee;
import com.app.core.FTE;
import com.app.core.PTE;
import com.app.exce.AllException;
import com.app.utils.AllValidations;

public class EmpImpleamentation implements EmpInf {

	private Map<Integer, Employee> map;

	public EmpImpleamentation() throws AllException {
		this.map = new HashMap<>();
		addFTEmployee("Aniket Baghel", "9876543210", "123456789012", "2023-06-01", 75000);
		addFTEmployee("Sakshi Verma", "9123456780", "234567890123", "2022-08-15", 68000);
		addFTEmployee("Ravi Kumar", "9988776655", "345678901234", "2021-11-10", 82000);
		addFTEmployee("Meera Sharma", "9012345678", "456789012345", "2020-03-25", 90000);

		addPTEmployee("Rahul Das", "9876501234", "567890123456", "2023-01-05", 25000);
		addPTEmployee("Kiran Patel", "9123467890", "678901234567", "2022-12-20", 20000);
		addPTEmployee("Simran Jain", "9001234567", "789012345678", "2021-09-18", 22000);
		addPTEmployee("Vikas Roy", "9898989898", "890123456789", "2020-04-12", 27000);

	}

	@Override
	public void addFTEmployee(String name, String pno, String adharNo, String doj, double sal) throws AllException {

		LocalDate date = LocalDate.parse(doj);
		AllValidations.phnoValidation(pno);
		AllValidations.adharValidation(adharNo);
		Employee e = new FTE(name, pno, adharNo, date, sal);
		map.put(e.getEid(), e);

	}

	@Override
	public void addPTEmployee(String name, String pno, String adharNo, String doj, double sal) throws AllException {

		LocalDate date = LocalDate.parse(doj);
		AllValidations.phnoValidation(pno);
		AllValidations.adharValidation(adharNo);
		Employee e = new PTE(name, pno, adharNo, date, sal);
		map.put(e.getEid(), e);

	}

	@Override
	public void deleteEmp(int cid) throws AllException {
		Employee e = map.get(cid);
		if (e != null) {
			map.remove(cid);
		}
	}

	@Override
	public void getEmpByAdharNo(String adhno) throws AllException {
		AllValidations.adharValidation(adhno);

		map.values().stream().filter(e -> e.getAdharNo().equals(adhno)).forEach(System.out::println);
	}

	@Override
	public void getAllEmp() {
		map.values().stream().forEach(System.out::println);
	}

	@Override
	public void getEmpSortedByDoj() {
		map.values().stream().sorted((p1, p2) -> p1.getDoj().compareTo(p2.getDoj())).forEach(System.out::println);

	}

}
