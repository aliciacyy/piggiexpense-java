package com.pigexpense.home;

public class Expense {
	
	private String user;
	private int number;
	private String description;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Expense(String user, int number, String description) {
		this.user = user;
		this.number = number;
		this.description = description;
	}
	
	

}
