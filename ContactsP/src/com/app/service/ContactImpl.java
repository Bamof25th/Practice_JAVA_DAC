package com.app.service;

import static com.app.validation.AllValidations.emailValidation;
import static com.app.validation.AllValidations.phnoValidate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import com.app.core.Contact;
import com.app.core.Key;
import com.app.exception.CustomException;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ContactImpl implements Contactin {

	private Map<Key, Contact> map;

	public ContactImpl() throws CustomException {
		this.map = new HashMap<Key, Contact>();

		ArrayList<String> ph1 = new ArrayList<>(List.of("9876543210", "9123456780"));
		addContact(ph1, "Aniket Baghel", "1925-05-20", "aniketbaghel@example.com");

		ArrayList<String> ph2 = new ArrayList<>(List.of("8899776655"));
		addContact(ph2, "Sakshi", "2000-04-13", "sakshiv@example.com");

		ArrayList<String> ph3 = new ArrayList<>(List.of("7766554433", "9900112233"));
		addContact(ph3, "Ravi Sharma", "1995-12-01", "ravis@example.com");

		ArrayList<String> ph4 = new ArrayList<>(List.of("9988776655"));
		addContact(ph4, "Pooja Patel", "1998-03-10", "poojapatel@example.com");

		ArrayList<String> ph5 = new ArrayList<>(List.of("9112233445", "9001122334"));
		addContact(ph5, "Aman Yadav", "1997-07-22", "amanyadav@example.com");

	}

	@Override
	public void addContact(ArrayList<String> phnos, String name, String dob, String email) throws CustomException {

		emailValidation(email);
		for (String p : phnos) {
			phnoValidate(p);
		}
		LocalDate d = LocalDate.parse(dob);
		Contact a = new Contact(phnos, name, d, email);
		// List<String> l = a.getPhnos();
		Key k = new Key(name, dob);
		map.put(k, a);
		System.out.println("Contact Added");
	}

	@Override
	public void displayAll() {

		map.keySet().stream().forEach(System.out::println);
		map.values().stream().forEach(System.out::println);

	}

	/*
	 * @Override public void updateContact(Key k, String email) { // TODO
	 * Auto-generated method stub
	 * 
	 * Contact c = map.get(k); c.setEmail(email);
	 * 
	 * }
	 */

	@Override
	public void remAllContact() throws CustomException {
		List<Key> keysToRemove = map.values().stream()
				.filter(p -> (LocalDate.now().getYear() - p.getDob().getYear()) > 80)
				.map(p -> new Key(p.getName(), p.getDob().toString())).collect(Collectors.toList());
		keysToRemove.forEach(map::remove);
	}

	@Override
	public void displayPHmaxNo() throws CustomException {
		Contact contactWithMaxPhones = map.values().stream()
				.max((c1, c2) -> Integer.compare(c1.getPhnos().size(), c2.getPhnos().size()))
				.orElseThrow(() -> new CustomException("No contacts found"));
		System.out.println(contactWithMaxPhones);
	}

	@Override
	public void displayDb() throws CustomException {

		map.values().stream().filter(p -> p.getDob().getMonthValue() == LocalDate.now().getMonthValue())
				.filter(p -> LocalDate.now().getDayOfMonth() - p.getDob().getDayOfMonth() == 3)
				.forEach(p -> System.out.println(p));
	}

	@Override
	public void updateContact(String dob, String name, String email, List<String> listOfNos) throws CustomException {

		Key newKey = new Key(name, dob);

		Contact c = map.get(newKey);
		if (email != null) {
			c.setEmail(email);
			System.out.println("email Updated");
		}

		if (!listOfNos.isEmpty() && listOfNos != null) {
			for (String p : listOfNos) {
				phnoValidate(p);
				c.getPhnos().add(p);
			}
			System.out.println("Updated phnos list!!");
		}

	}

}
