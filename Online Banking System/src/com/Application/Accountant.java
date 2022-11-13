package com.Application;

import java.util.Scanner;

import com.exception.CustomerException;
import com.usecase.AddNewCustomer;
import com.usecase.Deposite;
import com.usecase.RemoveAccByAccNo;
import com.usecase.UpdateDetails;
import com.usecase.ViewAllCustomer;
import com.usecase.ViewCustomer;
import com.usecase.withdrawMoney;

public class Accountant {

//   static boolean	running=true;
	
	public static void admin() {
		
		Scanner sc=new Scanner(System.in);
		
		 
		System.out.println();
		System.out.println("===================Hello ========================");
		System.out.println();
		
		System.out.println("===========please select option on the basis of your requirement============");
		System.out.println();
		
		System.out.println("press 1 : To Add new account for customer");
		System.out.println();
		System.out.println("press 2 : To edit account details");
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
		System.out.println("Press 8 : To return to Home page ");
		
		int choice = sc.nextInt();
		
		
		switch (choice) {
		case 1: {
			
			try {
				AddNewCustomer.main(null);
				
				System.out.println("--------select any one------");
				
				System.out.println("press 1 :to return to Home page ");
				System.out.println();
				System.out.println("press 2 :to return to previous page ");
				System.out.println();
				
				int x=sc.nextInt();
				
			          	switch (x) {
			        	    case 1: {
					
			              		Main.main(null);
			              		break;
		             		}
			        	    case 2: {
			    			   
			        	    	Accountant.admin();
			              		break;
			              	
		             		}
		            		default:
			              		throw new IllegalArgumentException("Unexpected value: " + x);
		              		}
				
				
				
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		case 2: {
			
			UpdateDetails.main(null);
			
			System.out.println("--------select any one------");
			
			System.out.println("press 1 :to return to Home page ");
			System.out.println();
			System.out.println("press 2 :to return to previous page ");
			System.out.println();
			
			int x=sc.nextInt();
			
		          	switch (x) {
		        	    case 1: {
				
		              		Main.main(null);
		              		break;
	             		}
		        	    case 2: {
		    			   
		        	    	Accountant.admin();
		              		break;
		              	
	             		}
	            		default:
		              		throw new IllegalArgumentException("Unexpected value: " + x);
	              		}
			
			break;
		}
		case 3: {
			
			RemoveAccByAccNo.main(null);
			
           	System.out.println("--------select any one------");
			
			System.out.println("press 1 :to return to Home page ");
			System.out.println();
			System.out.println("press 2 :to return to previous page ");
			System.out.println();
			
			int x=sc.nextInt();
			
		          	switch (x) {
		        	    case 1: {
				
		              		Main.main(null);
		              		break;
	             		}
		        	    case 2: {
		    			   
		        	    	Accountant.admin();
		              		break;
		              	
	             		}
	            		default:
		              		throw new IllegalArgumentException("Unexpected value: " + x);
	              		}
			
			break;
			
		}
		case 4: {
			
			ViewCustomer.main(null);
			
	        System.out.println("--------select any one------");
			
			System.out.println("press 1 :to return to Home page ");
			System.out.println();
			System.out.println("press 2 :to return to previous page ");
			System.out.println();
			
			int x=sc.nextInt();
			
		          	switch (x) {
		        	    case 1: {
				
		              		Main.main(null);
		              		break;
	             		}
		        	    case 2: {
		    			   
		        	    	Accountant.admin();
		              		break;
		              	
	             		}
	            		default:
		              		throw new IllegalArgumentException("Unexpected value: " + x);
	              		}
			
		
			break;
		}
		case 5: {
			
			ViewAllCustomer.main(null);
			
			  System.out.println("--------select any one------");
				
				System.out.println("press 1 :to return to Home page ");
				System.out.println();
				System.out.println("press 2 :to return to previous page ");
				System.out.println();
				
				int x=sc.nextInt();
				
			          	switch (x) {
			        	    case 1: {
					
			              		Main.main(null);
			              		break;
		             		}
			        	    case 2: {
			    			   
			        	    	Accountant.admin();
			              		break;
			              	
		             		}
		            		default:
			              		throw new IllegalArgumentException("Unexpected value: " + x);
		              		}
				
			
				break;
			
			
		}
		case 6: {
			   Deposite.main(null);
			
			  System.out.println("--------select any one------");
				
				System.out.println("press 1 :to return to Home page ");
				System.out.println();
				System.out.println("press 2 :to return to previous page ");
				System.out.println();
				
				int x=sc.nextInt();
				
			          	switch (x) {
			        	    case 1: {
					
			              		Main.main(null);
			              		break;
		             		}
			        	    case 2: {
			    			   
			        	    	Accountant.admin();
			              		break;
			              	
		             		}
		            		default:
			              		throw new IllegalArgumentException("Unexpected value: " + x);
		              		}
				
			
			break;
		}
		case 7: {
			  withdrawMoney.main(null);
				
			  System.out.println("--------select any one------");
				
				System.out.println("press 1 :to return to Home page ");
				System.out.println();
				System.out.println("press 2 :to return to previous page ");
				System.out.println();
				
				int x=sc.nextInt();
				
			          	switch (x) {
			        	    case 1: {
					
			              		Main.main(null);
			              		break;
		             		}
			        	    case 2: {
			    			   
			        	    	Accountant.admin();
			              		break;
			              	
		             		}
		            		default:
			              		throw new IllegalArgumentException("Unexpected value: " + x);
		              		}
				
			
			break;
		}
		case 8: {
//			running= false;
			
			Main.main(null);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		}
		
		
	}
	
	

