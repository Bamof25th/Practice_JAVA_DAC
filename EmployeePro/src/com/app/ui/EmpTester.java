package com.app.ui;

import java.util.Scanner;

import com.app.services.EmpImpleamentation;

public class EmpTester {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = true;
			EmpImpleamentation emp = new EmpImpleamentation();
			while (!exit) {
				try {
					System.out.println("Application Menu:\r\n" + "1. Add full time employee\r\n"
							+ "2. Add part time employee\r\n" + "3. Delete an employee by Emp Id\r\n"
							+ "4. Search employee details by Aadhaar number\r\n" + "5. Display all employee details\r\n"
							+ "6. Display all employee details sorted by date of joining\r\n" + "0. Exit\r\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Please Enter -> Name,Phno,AdharNo,DateOfJoining,Salary Per Month");
						emp.addFTEmployee(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble());
						System.out.println("Added FTE");
						break;
					case 2:
						System.out.println("Please Enter -> Name,Phno,AdharNo,DateOfJoining,Salary per Hours");
						emp.addPTEmployee(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble());
						System.out.println("Added PTE");
						break;
					case 3:
						System.out.println("To Delete An Emp Give his/her eid:");
						emp.deleteEmp(sc.nextInt());
						break;
					case 4:
						System.out.println("to Search Give its Adhar No:");
						emp.getEmpByAdharNo(sc.next());

						break;
					case 5:
						System.out.println("Display all employee details:");
						emp.getAllEmp();
						break;
					case 6:
						System.out.println("Display all employee details sorted by Date of Joining:");
						emp.getEmpSortedByDoj();
						break;
					case 0:
						exit = false;
						System.out.println("Chala Jaa!!");
						break;

					default:
						break;
					}

				} catch (Exception e) {

					System.out.println(e.getMessage());

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
