package com.usecase;

import java.util.List;
import java.util.Scanner;

import com.Application.Customer1;
import com.Application.Main;
import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;
import com.exception.TransactionException;
import com.model.Customer;
import com.model.Transaction;


public class LogInCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("..........Enter Your Log In Details........");
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println();
		
		System.out.println("enter your account number....");
		
		System.out.println();
		
	    int acc = scanner.nextInt();
	    
	    System.out.println("enter your account password....");
		
	    String pass = scanner.next();
	    
	    
	    CustomerDao dao = new CustomerDaoImpl();
	    
	    try {
		  Customer customer =	dao.logInCustomer(acc, pass);
		  
		  if(customer!=null) {
			  
			  System.out.println();
			  System.out.println("...........Logged In...........");
			  System.out.println();
			  System.out.println(customer);
			  
			   System.out.println();
		       System.out.println("select option on the basis of your requirement.........");
		       System.out.println();
		       System.out.println("press 1 : to transfer money.....");
		       System.out.println();
		       System.out.println("press 2 : to view transaction history......");
		       System.out.println();
		       System.out.println("press 3 : to return to home page......");
		       System.out.println();
		       
		    
			int z= scanner.nextInt();
		    
		    switch (z) {
			case 1: {
				
//				TransferMoney.main(null);
			   System.out.println("Enter your account number");
			   int s_Acc_No =  scanner.nextInt();
			   
			   System.out.println("Enter the amount you want to transfer");
			   int T_Money =  scanner.nextInt();
			   
			   System.out.println("Enter receiver account number");
			   int r_Acc_No =  scanner.nextInt();
			   
			   if(s_Acc_No!=customer.getC_Acc_No()) {
				   System.out.println("please enter correct account number");
				   throw new CustomerException("please enter correct account number");
			   }
			   else if(T_Money>customer.getC_Total_Amount()) {
				   System.out.println("insufficient balance....");
				   throw new CustomerException("insufficient balance....");
			   }
			   else {
				  String result = dao.transferMoney(s_Acc_No, T_Money, r_Acc_No);
				  
				  System.out.println(result);
				  System.out.println();
				  
				  System.out.println("press 1 : to log out");
				  
				  int c= scanner.nextInt();
				  
				  switch (c) {
				case 1: {
					
					Customer1.customer();
					
					break;
					
				}
               
				default:
					throw new IllegalArgumentException("Unexpected value: " + c);
				}
			   }
			   
				
				break;
			}
	        case 2: {
				
//	        view transaction history ......... .... ...... .......
	        	
	          try {
	        	  
			  List<Transaction> transactions =	dao.viewTransactionHistory(acc);
			  
			  transactions.forEach(s->{
				  System.out.println(s);
			  });
			  
			  System.out.println();
			  
			  System.out.println("press 1 : to log out");
			  
			  int c= scanner.nextInt();
			  
			  if(c==1) {
				  Customer1.customer();
			  }
			  
			  
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	
	        	
				break;
			}
            case 3: {
				
            	Main.main(args);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + z);
			}
		    
		  }
		  
		  else {
			  System.out.println("invalid user name or password");
			  LogInCustomer.main(args);
		  }
		  
		 
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
