package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.exception.CustomException;

public interface Contactin {
	void addContact(ArrayList<String> phnos, String name, String dob, String email) throws CustomException;

	void displayAll();

	void updateContact(String dob, String name, String email, List<String> listOfNos) throws CustomException;

	void remAllContact() throws CustomException; // remove all contact over age 80

	void displayPHmaxNo() throws CustomException;

	void displayDb() throws CustomException;

}
