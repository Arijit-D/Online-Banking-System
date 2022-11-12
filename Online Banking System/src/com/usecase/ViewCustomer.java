package com.usecase;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;
import com.model.Customer;

public class ViewCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

       Scanner scanner = new Scanner(System.in);
		
		System.out.println("--------Enter Account Number--------");
	    int acc = scanner.nextInt();
		
	    
	    
	    CustomerDao dao = new CustomerDaoImpl();
	    
	    try {
		Customer  customer =	dao.viewCustomer(acc);
		
		System.out.println(customer);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
