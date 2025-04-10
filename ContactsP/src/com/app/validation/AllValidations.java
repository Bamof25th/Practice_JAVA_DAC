package com.app.validation;

import com.app.exception.CustomException;

public class AllValidations {
	public static void emailValidation(String email) throws CustomException {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-z]+\\.(com|in|to|uk|usa)$";
		if (!email.isEmpty() && email != null) {
			if (!email.matches(regex)) {
				throw new CustomException("Invalid Email Please Enter a valid Email");
			}
		}

		System.out.println("OK!");

	}

	public static void phnoValidate(String phno) throws CustomException {
		String regx = "^[1-9][0-9]{9}$";
		if (!phno.matches(regx))
			throw new CustomException("Invalid Phno Please Enter a valid Phno");
		else {
			System.out.println("phno validated");
		}
	}
}
