package com.model;

public class Transaction {

	private int s_Acc_No;
	
	private int t_Money;
	
	private int r_Acc_No;
	
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}


	public Transaction(int s_Acc_No, int t_Money, int r_Acc_No) {
		super();
		this.s_Acc_No = s_Acc_No;
		this.t_Money = t_Money;
		this.r_Acc_No = r_Acc_No;
	}


	public int getS_Acc_No() {
		return s_Acc_No;
	}


	public void setS_Acc_No(int s_Acc_No) {
		this.s_Acc_No = s_Acc_No;
	}


	public int getT_Money() {
		return t_Money;
	}


	public void setT_Money(int t_Money) {
		this.t_Money = t_Money;
	}


	public int getR_Acc_No() {
		return r_Acc_No;
	}


	public void setR_Acc_No(int r_Acc_No) {
		this.r_Acc_No = r_Acc_No;
	}


	@Override
	public String toString() {
		return "Transaction [s_Acc_No=" + s_Acc_No + ", t_Money=" + t_Money + ", r_Acc_No=" + r_Acc_No + "]";
	}
	
	
	
	
}
