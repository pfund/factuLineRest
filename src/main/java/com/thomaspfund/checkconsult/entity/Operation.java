package com.thomaspfund.checkconsult.entity;

import java.util.Date;

public class Operation implements MongoEntity {

	private String id;
	
	private Date dateOperation;
	
	private String firstName;
	
	private String lastName;
	
	private String operationHospital;
	
	private Double amount;
	
	private String assistantOne;
	
	private Double assistantOneAmount;
	
	private String assistantTwo;
	
	private Double assistantTwoAmount;
	
	private Boolean payementRecieved;
	
	private Boolean assistantsPaid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
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

	public String getOperationHospital() {
		return operationHospital;
	}

	public void setOperationHospital(String operationHospital) {
		this.operationHospital = operationHospital;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAssistantOne() {
		return assistantOne;
	}

	public void setAssistantOne(String assistantOne) {
		this.assistantOne = assistantOne;
	}

	public Double getAssistantOneAmount() {
		return assistantOneAmount;
	}

	public void setAssistantOneAmount(Double assistantOneAmount) {
		this.assistantOneAmount = assistantOneAmount;
	}

	public String getAssistantTwo() {
		return assistantTwo;
	}

	public void setAssistantTwo(String assistantTwo) {
		this.assistantTwo = assistantTwo;
	}

	public Double getAssistantTwoAmount() {
		return assistantTwoAmount;
	}

	public void setAssistantTwoAmount(Double assistantTwoAmount) {
		this.assistantTwoAmount = assistantTwoAmount;
	}

	public Boolean getPayementRecieved() {
		return payementRecieved;
	}

	public void setPayementRecieved(Boolean payementRecieved) {
		this.payementRecieved = payementRecieved;
	}

	public Boolean getAssistantsPaid() {
		return assistantsPaid;
	}

	public void setAssistantsPaid(Boolean assistantsPaid) {
		this.assistantsPaid = assistantsPaid;
	}
	
}
