package com.app.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.exception.CustomException;
import com.app.service.ContactImpl;
import com.app.service.Contactin;

public class Test {

	public static void main(String[] args) throws CustomException {

		try (Scanner sc = new Scanner(System.in)) {

			// Creating an instance of ContactImpl which will auto-populate 5 sample
			// contacts
			Contactin contactService = new ContactImpl();

			boolean exit = false;

			while (!exit) {
				// Menu options
				System.out.println("\n========= Contact Management Menu =========");
				System.out.println("1. Display All Contacts");
				System.out.println("2. Add New Contact");
				System.out.println("3. Update Contact");
				System.out.println("4. Remove All Contacts Over Age 80");
				System.out.println("5. Display Max Phone Numbers in Contact");
				System.out.println("6. Display Contacts with DOB within 3 days of Today");
				System.out.println("7. Exit");
				System.out.print("Enter your choice: ");

				int choice = sc.nextInt();
				sc.nextLine(); // consume newline

				switch (choice) {
				case 1:
					// Display all contacts
					contactService.displayAll();
					break;

				case 2:
					// Add a new contact
					System.out.print("Enter name: ");
					String name = sc.nextLine();

					System.out.print("Enter date of birth (yyyy-mm-dd): ");
					String dob = sc.nextLine();

					System.out.print("Enter email: ");
					String email = sc.nextLine();

					System.out.print("How many phone numbers? ");
					int count = sc.nextInt();
					sc.nextLine(); // consume newline

					ArrayList<String> phnos = new ArrayList<>();
					for (int i = 0; i < count; i++) {
						System.out.print("Enter phone number " + (i + 1) + ": ");
						phnos.add(sc.nextLine());
					}

					contactService.addContact(phnos, name, dob, email);
					break;

				case 3:
					// Update a contact
					System.out.print("Enter name: ");
					String updateName = sc.nextLine();

					System.out.print("Enter date of birth (yyyy-mm-dd): ");
					String updateDob = sc.nextLine();

					System.out.print("Enter new email (or press Enter to skip): ");
					String newEmail = sc.nextLine();
					if (newEmail.isEmpty()) {
						newEmail = null;
					}

					System.out.print("How many new phone numbers to add? ");
					int numPhones = sc.nextInt();
					sc.nextLine(); // consume newline

					List<String> newPhones = new ArrayList<>();
					for (int i = 0; i < numPhones; i++) {
						System.out.print("Enter phone number " + (i + 1) + ": ");
						newPhones.add(sc.nextLine());
					}

					contactService.updateContact(updateDob, updateName, newEmail, newPhones);
					break;

				case 4:
					// Remove all contacts over age 80
					contactService.remAllContact();
					System.out.println("Removed contacts over age 80.");
					break;

				case 5:
					// Display contact(s) with max number of phone numbers
					contactService.displayPHmaxNo();
					break;

				case 6:
					// Display contacts with DOB 3 days before today
					contactService.displayDb();
					break;

				case 7:
					// Exit
					exit = true;
					System.out.println("Chala ja !");
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
				}
			}
		} catch (CustomException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}