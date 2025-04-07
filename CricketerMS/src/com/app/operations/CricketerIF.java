package com.app.operations;

public interface CricketerIF {
//	String name,int age,String email_id,String Phone,int rating

	void AddCriketer(String name, int age, String email_id, String Phone, int rating);

	String updateRating(int rating, int cId);

	void searchByName(String name);

	void displayAll();

	void SortByRating();


}
