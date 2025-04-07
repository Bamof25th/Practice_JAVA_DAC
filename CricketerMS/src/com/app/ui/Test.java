package com.app.ui;

import java.util.Scanner;

import com.app.operations.CricketerImplementation;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			CricketerImplementation cricketerManager = new CricketerImplementation();
			boolean exit = false;

			while (!exit) {
				System.out.println("\n========= CRICKETER MANAGEMENT MENU =========");
				System.out.println("1. Add Cricketer");
				System.out.println("2. Update Rating");
				System.out.println("3. Search by Name");
				System.out.println("4. Display All Cricketers");
				System.out.println("5. Sort Cricketers by Rating");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");

				int choice = sc.nextInt();
				sc.nextLine(); // consume newline

				switch (choice) {
				case 1:
					System.out.println("Enter Name:");
					String name = sc.nextLine();

					System.out.println("Enter Age:");
					int age = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter Email ID:");
					String email = sc.nextLine();

					System.out.println("Enter Phone Number:");
					String phone = sc.nextLine();

					System.out.println("Enter Rating:");
					int rating = sc.nextInt();
					sc.nextLine();

					cricketerManager.AddCriketer(name, age, email, phone, rating);
					break;

				case 2:
					System.out.println("Enter Cricketer ID:");
					int cId = sc.nextInt();

					System.out.println("Enter New Rating:");
					int newRating = sc.nextInt();
					sc.nextLine();

					String result = cricketerManager.updateRating(newRating, cId);
					System.out.println(result);
					break;

				case 3:
					System.out.println("Enter Name to Search:");
					String searchName = sc.nextLine();
					cricketerManager.searchByName(searchName);
					break;

				case 4:
					cricketerManager.displayAll();
					break;

				case 5:
					cricketerManager.SortByRating();
					break;

				case 0:
					exit = true;
					System.out.println("Exiting Cricketer Manager. Goodbye!");
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e.getMessage());
		}
	}
}
