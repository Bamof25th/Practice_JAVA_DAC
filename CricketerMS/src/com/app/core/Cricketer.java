package com.app.core;

public class Cricketer {
	private int cId;
	private String name;
	private int age;
	private String email_id;
	private String phone ;
	private int rating;
	
	public static int Counter;

	public Cricketer(String name, int age, String email_id, String phone, int rating) {
		this.cId = ++Counter;
		this.name = name;
		this.age = age;
		this.email_id = email_id;
		this.phone = phone;
		this.rating = rating;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public static int getCounter() {
		return Counter;
	}

	public static void setCounter(int counter) {
		Counter = counter;
	}

	@Override
	public String toString() {
	    return "Cricketer {" +
	           "\n  cId      = " + cId +
	           ",\n  name     = '" + name + '\'' +
	           ",\n  age      = " + age +
	           ",\n  email_id = '" + email_id + '\'' +
	           ",\n  Phone    = '" + phone + '\'' +
	           ",\n  rating   = " + rating +
	           "\n}";
	}

}
