package com.dao;

import java.util.List;

import com.exception.CustomerException;
import com.exception.TransactionException;
import com.model.Customer;
import com.model.Transaction;

public interface CustomerDao {
	
	public String addCustomer(Customer custoemr)throws CustomerException;
	
	public String updateDetails(String c_Mob_No,String c_Address,String c_Password,int c_Acc_No) throws CustomerException;
	
	public String removeAccByAccNo(int c_Acc_no) throws CustomerException;
	
	public Customer viewCustomer(int c_Acc_no) throws CustomerException;
	
	public List<Customer> viewAllCustomers() throws CustomerException;
	
	public String depositeMoney(int c_Acc_No, String d_Name, int d_Amount) throws CustomerException;
	
	public String withdrawMoney(int c_Acc_No, String w_Name, int w_Amount) throws CustomerException;
	
    public Customer logInCustomer(int c_Acc_No, String c_Password) throws CustomerException;
    
    public String transferMoney(int s_Acc_No,int T_money,int r_Acc_No) throws CustomerException;
    
    public List<Transaction> viewTransactionHistory(int c_Acc_No) throws TransactionException;
    
}
