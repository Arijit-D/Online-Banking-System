package com.Application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
    Scanner scanner = new Scanner(System.in);
		
	System.out.println(".......Welcome to ARD Bank.......");
	System.out.println();
	System.out.println("-------Plese Select Options--------");
	System.out.println("--------------------------------------");
	
	System.out.println("Press 1 for Login As Accountant");
	System.out.println();
	System.out.println("Press 2 for login As Customer");
	System.out.println();
	System.out.println("Press 3 for Exit");
	
	int key = scanner.nextInt();
	
	switch (key) {
	case 1: {
		
		System.out.println("Enter Accountant Id");
	    String accountant = scanner.next();
	    
	    System.out.println("Enter Accountant Password");
	    String Password = scanner.next();
	    
	    if(accountant.equals("Admin") && Password.equals("Accountant")) {
	    	
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
//		Customer.login();
	   
	  
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
