package com.usecase;

import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;
import com.model.Customer;

public class ViewAllCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
		  List<Customer> customers = dao.viewAllCustomers();
		  
		  customers.forEach(s->{
			  System.out.println(s);
		  });
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
