package com.atm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.atm.model.User;
import com.atm.utility.SessionCreation;

public class DAOOperations {

	public static void main(String[] args) {

//		DAOOperations obj = new DAOOperations();
//		obj.pinGenerate();
		// obj.accountNumberGenerate();

	}

	public void userInsert(User user) {

		Session session = SessionCreation.getSession();
		Transaction t = session.beginTransaction();

		session.save(user);
		t.commit();
	}

	public int pinGenerate() {

		int number = (int) (Math.random() * 10000);
		System.out.println(number);

		return number;

	}

	public String accountNumberGenerate() {

		int sum = 0;

		int arr1[] = new int[16];

		int arr[] = new int[16];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = (int) (Math.random() * 10);
		}

		for (int i = 0; i < arr.length; i++) {

			arr1[i] = arr[i];
		}

		System.out.println("old array");
		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < arr1.length; i++) {

			if (i % 2 == 0) {
				arr1[i] = arr1[i] * 2;

			}
		}

		System.out.println();
		System.out.print("double number at even places");

		for (int i : arr1) {
			System.out.print(i + ",");
		}
System.out.println("Double numbers");
System.out.println();
		for (int i = arr1.length - 1; i >= 0; i--) {

			if (i % 2 == 0) {
				if (arr1[i] >= 10) {
					arr1[i] = returnNumber(arr1[i]);
				}
			}
		}

		String number = "";
		for (int a : arr) {
			number = number + " " + a;
		}
		System.out.println();
		System.out.println("after return");

		for (int i = 0; i < arr1.length; i++) {

			System.out.print(arr1[i] + " ");

			sum = sum + arr1[i];
		}
		
		int count=0;

		System.out.println("number after summing");
		System.out.println(sum);

		if (sum % 10 == 0) {
			System.out.print("account number valid");
			System.out.println();
			count=1;
			//return number;
		}

		
			if(count==1)
			{
				return number;
			}
			
			else
			{
				DAOOperations obj = new DAOOperations();
				obj.accountNumberGenerate();
				
			}
			
		return number;
	}

	public int returnNumber(int num) {

		int remainder = 0;
		int sum = 0;

		while (true) {

			remainder = num % 10;

			sum = sum + remainder;
			return sum;
		}

	}
	
}
