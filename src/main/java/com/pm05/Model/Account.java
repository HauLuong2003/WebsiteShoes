package com.pm05.Model;

public class Account {
     private int id;
     private String user;
     private String pass;
     private int customer;
     private int admin;
	
     
     public Account(int id, String user, String pass, int customer, int admin) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.customer = customer;
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public String getUser() {
		return user;
	}
	public String getPass() {
		return pass;
	}
	public int getCustomer() {
		return customer;
	}
	public int getAdmin() {
		return admin;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
     @Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", pass=" + pass + ", customer=" 
	+ customer + ", admin=" + admin+ "]";
	}
     
}
