package com.usecase;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;
import com.model.Customer;

public class AddNewCustomer {

	public static void main(String[] args) throws CustomerException {
		// TODO Auto-generated method stub
             
		
        Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter CustomerName:");
		String c_Name = sc.next();

		System.out.println("Enter password:");
		String c_Password = sc.next();
        
		System.out.println("Enter Address : ");
		String c_Address = sc.next();
		
		System.out.println("Enter Mobile Number : ");
		String c_Mob_No = sc.next();
		
		System.out.println("Enter Email : ");
		String c_Email = sc.next();
		
		System.out.println("Enter Amount : ");
		int c_Total_Amount = sc.nextInt();
		
		
		if(c_Total_Amount<1000) {
			throw new CustomerException("Please enter more than 1000 rupee");
		}
		
		
		CustomerDao dao = new CustomerDaoImpl();
		
		Customer customer = new Customer();
		
		customer.setC_Name(c_Name);
		customer.setC_Password(c_Password);
		customer.setC_Address(c_Address);
		customer.setC_Mob_No(c_Mob_No);
		customer.setC_Email(c_Email);
		customer.setC_Total_Amount(c_Total_Amount);
		
		String result;
		try {
			result = dao.addCustomer(customer);
			System.out.println(result);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
