package com.usecase;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;

public class Deposite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("........Enter Details.......");
		
		Scanner scanner= new Scanner(System.in);
		
//		int c_Acc_No, String c_Name, int d_Amount, int c_Total_Amount
		
		System.out.println("Enter customer account number");
	    int c_Acc_No = scanner.nextInt();
	    
	    System.out.println("Enter depositer name");
	    String d_Name = scanner.next();
	    
	    System.out.println("Enter ammount");
	    int d_Amount = scanner.nextInt();
	    
	  
	    CustomerDao dao = new CustomerDaoImpl();
	    
	    try {
		  String result = dao.depositeMoney(c_Acc_No, d_Name, d_Amount);
		  System.out.println(result);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
