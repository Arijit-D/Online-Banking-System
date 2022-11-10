package com.Application;

import java.util.Scanner;

public class Accountant {

   static boolean	ordering=true;
	
	public static void admin() {
		
		Scanner sc=new Scanner(System.in);
		
		do {
		System.out.println("Hello Arijit");
		System.out.println();
		
		System.out.println("press 1 : To Add new account for customer");
		System.out.println();
		System.out.println("press 2 : Edit already available account");
		System.out.println();
		System.out.println("Press 3 : To Remove the account by using account number");
		System.out.println();
		System.out.println("Press 4 : To View particular account details by giving account number");
		System.out.println();
		System.out.println("Press 5 : To View all the account details");
		System.out.println();
		System.out.println("Press 6 : To deposit Money");
		System.out.println();
		System.out.println("Press 7 : To withdraw Money");
		System.out.println();
		System.out.println("Press 8 : For Exit ");
		
		int choice = sc.nextInt();
		
		
		switch (choice) {
		case 1: {
			
			break;
		}
		case 2: {
			
			break;
		}
		case 3: {
			
		}
		case 4: {
			
		}
		case 5: {
			
		}
		case 6: {
			
		}
		case 7: {
			
		}
		case 8: {
			ordering= false;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		}while(ordering);
		
		
	}
	
	
}
