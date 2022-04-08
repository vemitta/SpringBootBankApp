package com.hashedin.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue
	private int id;
	
	private Date expenseDate;
	
	private double expenseSpent;
	
	public Expense() {
		
	}

	public Expense(Date expenseDate, double expenseSpent) {
		super();
		this.expenseDate = expenseDate;
		this.expenseSpent = expenseSpent;
	}

	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	public double getExpenseSpent() {
		return expenseSpent;
	}

	public void setExpenseSpent(double expenseSpent) {
		this.expenseSpent = expenseSpent;
	}
		
}