package com.thomaspfund.checkconsult.entity;

import java.util.Date;

public class Assistance implements MongoEntity {

	private String id;
	
	private Date dateAssistance;
	
	private String operator;
	
	private String firstName;
	
	private String lastName;
	
	private Double amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateAssistance() {
		return dateAssistance;
	}

	public void setDateAssistance(Date dateAssistance) {
		this.dateAssistance = dateAssistance;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
