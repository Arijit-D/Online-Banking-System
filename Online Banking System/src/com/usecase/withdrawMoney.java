package com.usecase;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;

public class withdrawMoney {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

	System.out.println("........Enter Details.......");
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter customer account number");
	    int c_Acc_No = scanner.nextInt();
	    
	    System.out.println("Enter  name");
	    String w_Name = scanner.next();
	    
	    System.out.println("Enter ammount");
	    int w_Amount = scanner.nextInt();
	    
	  
	    CustomerDao dao = new CustomerDaoImpl();
	    
	    try {
		  String result = dao.withdrawMoney(c_Acc_No, w_Name, w_Amount);
		  System.out.println(result);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
