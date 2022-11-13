package com.Application;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
    Scanner scanner = new Scanner(System.in);
		
	System.out.println(".......Welcome to ARD Bank.......");
	System.out.println();
	System.out.println("-------Please Select Option--------");
	System.out.println("--------------------------------------");
	
	System.out.println("Press 1 to Login As Accountant");
	System.out.println();
	System.out.println("Press 2 to login As Customer");
	System.out.println();
	System.out.println("Press 3 to Exit");
	
	int key = scanner.nextInt();
	
	switch (key) {
	case 1: {
		
		System.out.println("Enter Accountant Id");
	    String accountant = scanner.next();
	    
	    System.out.println("Enter Accountant Password");
	    String Password = scanner.next();
	    
	    if(accountant.equals("Admin") && Password.equals("1234")) {
	    	
	    	Accountant.admin();
	    	
	    }
	    
	    else 
		{
		System.out.println("Wrong Username And PassWord");
		Main.main(args);
		}
	
	    break;
	    
		
	}
   case 2: {
	   
	    Customer1.customer();
	  
		break;
	    
		
	}
   case 3: {
		
	   System.out.println("...... BYE......");
	
		
		break;
		
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + key);
	}
		
		
	}

}
