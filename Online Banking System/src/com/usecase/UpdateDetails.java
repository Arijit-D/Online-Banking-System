package com.usecase;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;

public class UpdateDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=====Enter Proper Dttails to update Acount Details=====");
		
		System.out.println();
		
		System.out.println("Enter Mobile Number");
		System.out.println();
		
	    String mob = scanner.next();
	    
	    System.out.println("Enter Address");
		System.out.println();
		
		String add = scanner.next();
		
	    System.out.println("Enter password");
		System.out.println();
			
		String pass = scanner.next();
		
		System.out.println("Enter Account No.");
		System.out.println();
				
		int accNo = scanner.nextInt();
		
		
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
		String  result =	dao.updateDetails(mob, add, pass, accNo);
		
		System.out.println(result);
		
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
