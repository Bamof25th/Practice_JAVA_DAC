package com.app.operations;

import java.util.HashMap;

import com.app.core.Cricketer;

public class CricketerImplementation implements CricketerIF {

	private HashMap<Integer, Cricketer> Cricketers;

	public CricketerImplementation() {
		this.Cricketers = new HashMap<>();
		AddCriketer("Virat Kohli", 35, "virat@example.com", "9876543210", 95);
		AddCriketer("Rohit Sharma", 36, "rohit@example.com", "9123456780", 90);
		AddCriketer("MS Dhoni", 42, "msd@example.com", "9988776655", 97);
		AddCriketer("Jasprit Bumrah", 30, "bumrah@example.com", "9112233445", 89);
		AddCriketer("Hardik Pandya", 31, "hardik@example.com", "9090909090", 85);
	}

	@Override
	public void AddCriketer(String name, int age, String email_id, String Phone, int rating) {
		Cricketer c = new Cricketer(name, age, email_id, Phone, rating);
		Cricketers.put(c.getcId(), c);
		System.out.println("Cricketer Added Succesfully!");
	}

	@Override
	public String updateRating(int rating, int cId) {
		Cricketer c = Cricketers.get(cId);
		c.setRating(rating);
		return "Rating Updated SuccessFully";
	}

	@Override
	public void searchByName(String name) {
		Cricketers.values().stream().filter(c -> c.getName().toLowerCase().equals(name.toLowerCase()))
				.forEach(c -> System.out.println(c));
	}

	@Override
	public void displayAll() {
		Cricketers.values().stream().forEach(c -> System.out.println(c));
	}

	@Override
	public void SortByRating() {
		Cricketers.values().stream().sorted((c1, c2) -> Integer.compare(c2.getRating(), (c1.getRating())))
				.forEach(c -> System.out.println(c));

	}

}
