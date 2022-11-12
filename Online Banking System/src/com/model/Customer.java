package com.model;

public class Customer {
	
  private int c_Acc_No ; 
  private String  c_Name ;
  private String c_Password;
  private String c_Address;
  private String c_Mob_No;
  private String c_Email;
  private int c_Total_Amount;
   
  public Customer() {
	// TODO Auto-generated constructor stub
}


public Customer(int c_Acc_No, String c_Name, String c_Password, String c_Address, String c_Mob_No, String c_Email,
		int c_Total_Amount) {
	super();
	this.c_Acc_No = c_Acc_No;
	this.c_Name = c_Name;
	this.c_Password = c_Password;
	this.c_Address = c_Address;
	this.c_Mob_No = c_Mob_No;
	this.c_Email = c_Email;
	this.c_Total_Amount = c_Total_Amount;
}

public int getC_Acc_No() {
	return c_Acc_No;
}


public void setC_Acc_No(int c_Acc_No) {
	this.c_Acc_No = c_Acc_No;
}


public String getC_Name() {
	return c_Name;
}


public void setC_Name(String c_Name) {
	this.c_Name = c_Name;
}


public String getC_Password() {
	return c_Password;
}


public void setC_Password(String c_Password) {
	this.c_Password = c_Password;
}


public String getC_Address() {
	return c_Address;
}


public void setC_Address(String c_Address) {
	this.c_Address = c_Address;
}


public String getC_Mob_No() {
	return c_Mob_No;
}


public void setC_Mob_No(String c_Mob_No) {
	this.c_Mob_No = c_Mob_No;
}


public String getC_Email() {
	return c_Email;
}


public void setC_Email(String c_Email) {
	this.c_Email = c_Email;
}


public int getC_Total_Amount() {
	return c_Total_Amount;
}


public void setC_Total_Amount(int c_Total_Amount) {
	this.c_Total_Amount = c_Total_Amount;
}


@Override
public String toString() {
	return "Customer [c_Acc_No=" + c_Acc_No + ", c_Name=" + c_Name + ", c_Password=" + c_Password + ", c_Address="
			+ c_Address + ", c_Mob_No=" + c_Mob_No + ", c_Email=" + c_Email + ", c_Total_Amount=" + c_Total_Amount
			+ "]";
}
  
  
	
	
}
