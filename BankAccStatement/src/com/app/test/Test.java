package com.app.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("D:\\STS_V_3&4\\PracticeAssignments\\BankAccStatement\\src\\BankStatement.txt");
			BufferedReader br = new BufferedReader(fr);
			List<String> li = br.lines().skip(1).collect(Collectors.toList());
			System.out.println(li);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

//1. This question is NOT for lab exam , but definitely helpful in your coding rounds of interviews.
//
//Write a java program to read a text file which contains bank account statement of a month. 
//First row of file contains field names, remaining rows contains transaction data.
//Values of each row are separated by comma
//
//Display following details on the console: 
//Sum of all deposits
//Max deposit amount
//Shopping expenses (sum of withdrawals for shopping)
//Date on which maximum amount withdrawn
//
//For example: 
//Name of the file: Jan2025.txt
//Content of the file: 
//TransactionDate,Narration,WithdrawalAmount,DepositAmount
//01-01-2025,Salary Credit,0.0,50000.0
//01-01-2025,Mobile Recharge,300.0,0.0
//02-01-2025,DTH Recharge,1000.0,0.0
//02-01-2025,Rent Transfer,11000.0,0
//02-01-2025,Cashback Paytm,0.0,1000.0
//05-01-2025,Shopping,5000.0,0.0
//10-01-2025,Shopping,7000.0,0.0
//15-01-2025,Cashback,0.0,3000.0
//25-01-2025,Mobile Purchase,10000.0,0.0
//31-01-2025,Dining,1200.0,0.0
//
//Expected output on console:
//Sum of all deposits = 54000.0
//Max deposit amount= 50000.0
//Shopping expenses = 12000.0
//Date on which max amount withdrawn= 02-01-2025
