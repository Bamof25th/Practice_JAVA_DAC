package com.app.utils;

import com.app.exce.AllException;

public class AllValidations {

	public static void adharValidation(String a) throws AllException {

		if (!a.matches("^\\S+$")) {
			throw new AllException("please enter a valid adhar no!!");
		}
		System.out.println("Adhar validated !");
	}

	public static void phnoValidation(String a) throws AllException {

		if (!a.matches("^[0-9]*$")) {
			throw new AllException("please enter a valid phone  no!!");
		}
		System.out.println("phno validated !");
	}

}
