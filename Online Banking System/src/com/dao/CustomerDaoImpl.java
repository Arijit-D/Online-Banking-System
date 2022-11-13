package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.CustomerException;
import com.exception.TransactionException;
import com.model.Customer;
import com.model.Transaction;
import com.utility.DBUtil;
public class CustomerDaoImpl implements CustomerDao{


	@Override
	public String addCustomer(Customer custoemer) throws CustomerException {
		// TODO Auto-generated method stub
		
		String result = "not inserted";
		
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement
					("insert into Customer (c_Name,c_Password,c_Address,c_Mob_No,c_Email,c_Total_Amount) values(?,?,?,?,?,?)");
				
			
			ps.setString(1, custoemer.getC_Name());
			ps.setString(2, custoemer.getC_Password());
			ps.setString(3, custoemer.getC_Address());
			ps.setString(4, custoemer.getC_Mob_No());
			ps.setString(5, custoemer.getC_Email());
			ps.setInt(6, custoemer.getC_Total_Amount());
			
			
			int x=ps.executeUpdate();
			if(x>0) {
				result="Customer Registered Sucessfully..!";
			}
			}catch (SQLException e) {
				result=e.getMessage();
				throw new CustomerException(result);
			}
		
		return result;
	}

	@Override
	public String updateDetails(String c_Mob_No,String c_Address,String c_Password,int c_Acc_No) throws CustomerException {
		// TODO Auto-generated method stub
		
		String result = "not updated";
	    
         try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement
					("UPDATE customer SET c_Mob_No= ?,c_Address=?,c_Password=? where c_Acc_No=?");
				
			ps.setString(1, c_Mob_No);
			ps.setString(2, c_Address);
			ps.setString(3, c_Password);
			ps.setInt(4,c_Acc_No);
			
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				result = "updated";
			}
			else {
				throw new CustomerException(" Acc no does not exists..!");
			}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new CustomerException(e.getMessage());
			}
		
		
         return result;
		
		
	}

	@Override
	public String removeAccByAccNo(int c_Acc_no) throws CustomerException {
		// TODO Auto-generated method stub
		String result = "not Deleted";
	    
        try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement
					("DELETE FROM CUSTOMER WHERE c_Acc_No=?");
				
			ps.setInt(1, c_Acc_no);
			
			
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				result = "Deleted";
			}
			else {
				throw new CustomerException(" Acc no does not exists..!");
			}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new CustomerException(e.getMessage());
			}
		
		
        return result;
	}

	@Override
	public Customer viewCustomer(int c_Acc_no) throws CustomerException {
		// TODO Auto-generated method stub
		Customer customer= null;
		
		  try(Connection conn=DBUtil.provideConnection()){
				
				PreparedStatement ps=conn.prepareStatement
						("select*from customer where c_Acc_No=?");
					
				ps.setInt(1, c_Acc_no);
				
			    ResultSet rs = ps.executeQuery();
			    
			    if(rs.next()) {
			      int ac =	rs.getInt("c_Acc_No");
			      String n = rs.getString("c_Name");
			      String p = rs.getString("c_Password");
			      String ad = rs.getString("c_Address");
			      String mn = rs.getString("c_Mob_No");
			      String e = rs.getString("c_Email");
			      int ta =	rs.getInt("c_Total_Amount");
			      
			      customer = new Customer(ac,n,p,ad,mn,e,ta);
			      
			    }
			    else {
			    	throw new CustomerException("Account no does not exists");
			    }
				
				
				}catch (SQLException e) {
					e.printStackTrace();
					throw new CustomerException(e.getMessage());
				}
			
		
		return customer;
	}

	
	@Override
	public List<Customer> viewAllCustomers() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> customers= new ArrayList<>();
		
		
		  try(Connection conn=DBUtil.provideConnection()){
				
				PreparedStatement ps=conn.prepareStatement
						("select*from customer");
					
				
			    ResultSet rs = ps.executeQuery();
			    
			    while(rs.next()) {
			      int ac =	rs.getInt("c_Acc_No");
			      String n = rs.getString("c_Name");
			      String p = rs.getString("c_Password");
			      String ad = rs.getString("c_Address");
			      String mn = rs.getString("c_Mob_No");
			      String e = rs.getString("c_Email");
			      int ta =	rs.getInt("c_Total_Amount");
			      
			     Customer customer = new Customer(ac,n,p,ad,mn,e,ta);
			     
			     customers.add(customer);
			      
			    }
				
				
				}catch (SQLException e) {
					e.printStackTrace();
					throw new CustomerException(e.getMessage());
				}
		
		
		return customers;
	}

	@Override
	public String depositeMoney(int c_Acc_No, String d_Name, int d_Amount) throws CustomerException {
		// TODO Auto-generated method stub
		String result = "done";
		
		
		 try(Connection conn=DBUtil.provideConnection()){
				
				PreparedStatement ps=conn.prepareStatement
						("select*from customer where c_Acc_No=?");
					
				ps.setInt(1, c_Acc_No);
				
			    ResultSet rs = ps.executeQuery();
			    
			    if(rs.next()) {
			       
			    
			    	
			    	try(Connection conn1=DBUtil.provideConnection()) {
			    		
			    	PreparedStatement ps1 =	conn1.prepareStatement("insert into deposite values(?,?,?)");
			    	
			    	ps1.setInt(1, c_Acc_No);
			    	ps1.setString(2, d_Name);
			    	ps1.setInt(3, d_Amount);
			    	
			        int x =	ps1.executeUpdate();
			        
			        if(x>0) {
			        	
			        	
			        	
				    	try(Connection conn2=DBUtil.provideConnection()) {
				    		
				    	PreparedStatement ps2 =	conn2.prepareStatement("update customer set c_Total_Amount=c_Total_Amount+? where c_Acc_No = ?");
				    	
				    	ps2.setInt(1, d_Amount);
				    	ps2.setInt(2, c_Acc_No);
				    	
				        int y =	ps2.executeUpdate();
				        
				        if(x>0) {
				        	
				        	result = "done";
				        	
				        }
				        else {
				        	throw new CustomerException("account no does not exists");
				        }
							
						} catch (SQLException e) {
							// TODO: handle exception
							e.printStackTrace();
							throw new CustomerException(e.getMessage());
						}
				    	
			        
			        	
			        }
						
					} catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
						throw new CustomerException(e.getMessage());
					}
			    	
			    
			      
			    }
			    else {
			    	throw new CustomerException("Account no does not exists");
			    }
				
				
				}catch (SQLException e) {
					e.printStackTrace();
					throw new CustomerException(e.getMessage());
				}
			
		
		
		return result;
	}

	@Override
	public String withdrawMoney(int c_Acc_No, String w_Name, int w_Amount) throws CustomerException {
		// TODO Auto-generated method stub
		
		
		String result = "done";
		
		
		 try(Connection conn=DBUtil.provideConnection()){
				
				PreparedStatement ps=conn.prepareStatement
						("select*from customer where c_Acc_No=?");
					
				ps.setInt(1, c_Acc_No);
				
			    ResultSet rs = ps.executeQuery();
			    
			    if(rs.next()) {
			       
			    
			    	
			    	try(Connection conn1=DBUtil.provideConnection()) {
			    		
			    	PreparedStatement ps1 =	conn1.prepareStatement("insert into deposite values(?,?,?)");
			    	
			    	ps1.setInt(1, c_Acc_No);
			    	ps1.setString(2, w_Name);
			    	ps1.setInt(3, w_Amount);
			    	
			        int x =	ps1.executeUpdate();
			        
			        if(x>0) {
			        	
			        	
			        	
				    	try(Connection conn2=DBUtil.provideConnection()) {
				    		
				    	PreparedStatement ps2 =	conn2.prepareStatement("update customer set c_Total_Amount=c_Total_Amount-? where c_Acc_No = ?");
				    	
				    	ps2.setInt(1, w_Amount);
				    	ps2.setInt(2, c_Acc_No);
				    	
				        int y =	ps2.executeUpdate();
				        
				        if(x>0) {
				        	
				        	result = "Withdraw Done";
				        	
				        }
				        else {
				        	throw new CustomerException("account no does not exists");
				        }
							
						} catch (SQLException e) {
							// TODO: handle exception
							e.printStackTrace();
							throw new CustomerException(e.getMessage());
						}
				    	
			        
			        	
			        }
						
					} catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
						throw new CustomerException(e.getMessage());
					}
			    	
			    
			      
			    }
			    else {
			    	throw new CustomerException("Account no does not exists");
			    }
				
				
				}catch (SQLException e) {
					e.printStackTrace();
					throw new CustomerException(e.getMessage());
				}
			
		
		
		return result;
		
		
		
	}

	@Override
	public Customer logInCustomer(int c_Acc_No, String c_Password) throws CustomerException {
		// TODO Auto-generated method stub
		

		
		Customer customer=null;
		
		try (Connection conn= DBUtil.provideConnection()){
			
			
			PreparedStatement ps= conn.prepareStatement("select * from Customer where c_Acc_No=? AND c_Password = ?");
			
			
			ps.setInt(1, c_Acc_No);
			ps.setString(2, c_Password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next())
			{
				int ac= rs.getInt("c_Acc_No");
				String n= rs.getString("c_Name");
				String p= rs.getString("c_Password");
				String a= rs.getString("c_Address");
				String m= rs.getString("c_Mob_No");
				String e= rs.getString("c_Email");
				int Ta= rs.getInt("c_Total_Amount");
				
				customer = new Customer(ac, n, p, a, m, e, Ta);
				
			}else {
//				customer="Invalid Username or password..";
			}
				
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		
		
		return customer;
		
	}

	@Override
	public String transferMoney(int s_Acc_No, int T_money, int r_Acc_No) throws CustomerException {
		// TODO Auto-generated method stub
		
		String result = "not done";
		
		
		 try(Connection conn=DBUtil.provideConnection()){
				
				PreparedStatement ps=conn.prepareStatement
						("select*from customer where c_Acc_No=?");
					
				ps.setInt(1, r_Acc_No);
				
			    ResultSet rs = ps.executeQuery();
			    
			    if(rs.next()) {
			       
			    
			    	
			    	try(Connection conn1=DBUtil.provideConnection()) {
			    		
			    	PreparedStatement ps1 =	conn1.prepareStatement("insert into transaction values(?,?,?)");
			    	
			    	ps1.setInt(1, s_Acc_No);
			    	ps1.setInt(2, T_money);
			    	ps1.setInt(3, r_Acc_No);
			    	
			        int x =	ps1.executeUpdate();
			        
			        if(x>0) {
			        	
			        	
			        	
				    	try(Connection conn2=DBUtil.provideConnection()) {
				    		
				    	PreparedStatement ps2 =	conn2.prepareStatement("update customer set c_Total_Amount=c_Total_Amount-? where c_Acc_No = ?");
				    	
				    	ps2.setInt(1, T_money);
				    	ps2.setInt(2, s_Acc_No);
				    	
				        int y =	ps2.executeUpdate();
				        
				        if(x>0) {
				        	
				        	result = "Done";
				        	
				        }
				        else {
				        	throw new CustomerException("account no does not exists");
				        }
							
						} catch (SQLException e) {
							// TODO: handle exception
							e.printStackTrace();
							throw new CustomerException(e.getMessage());
						}
				    	
			        
			        	
			        }
			        
                        if(x>0) {
			        	
				    	try(Connection conn2=DBUtil.provideConnection()) {
				    		
				    	PreparedStatement ps2 =	conn2.prepareStatement("update customer set c_Total_Amount=c_Total_Amount+? where c_Acc_No = ?");
				    	
				    	ps2.setInt(1, T_money);
				    	ps2.setInt(2, r_Acc_No);
				    	
				        int y =	ps2.executeUpdate();
				        
				        if(x>0) {
				        	
				        	result = "Done";
				        	
				        }
				        else {
				        	throw new CustomerException("account no does not exists");
				        }
							
						} catch (SQLException e) {
							// TODO: handle exception
							e.printStackTrace();
							throw new CustomerException(e.getMessage());
						}
				    	
			        
			        	
			        }
						
					} catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
						throw new CustomerException(e.getMessage());
					}
			    	
			    
			      
			    }
			    else {
			    	throw new CustomerException("Account no does not exists");
			    }
				
				
				}catch (SQLException e) {
					e.printStackTrace();
					throw new CustomerException(e.getMessage());
				}
			
		
		
		return result;
		
		
		
	}

	@Override
	public List<Transaction> viewTransactionHistory(int c_Acc_No) throws TransactionException {
		// TODO Auto-generated method stub
		
		List<Transaction> transactions = new ArrayList<>();
		
	  
	  
	  try (Connection  conn = DBUtil.provideConnection()){
		  
		PreparedStatement ps =  conn.prepareStatement("select*from Transaction where sender_Acc_No = ? OR receiver_Acc_No=?");
		
		ps.setInt(1, c_Acc_No);
		ps.setInt(2, c_Acc_No);
		
	  ResultSet rs = ps.executeQuery();
	  
	  
	  while(rs.next()) {
		 int s = rs.getInt("sender_Acc_No");
		 int a = rs.getInt("transaction_Amount");
		 int r = rs.getInt("receiver_Acc_No");
		 
		 Transaction transaction = new Transaction(s,a,r);
		 
		 transactions.add(transaction);
	  }
	  
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
		
	}
		
		
		return transactions;
	}

	

	

}
