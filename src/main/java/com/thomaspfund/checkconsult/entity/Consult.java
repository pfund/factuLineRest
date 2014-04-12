package com.thomaspfund.checkconsult.entity;

import java.util.Date;

public class Consult {

	private String id;
	
	private Integer order;
	
	private Date dateConsult;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	private Double consultationPrice;
	
	private Double rebate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Date getDateConsult() {
		return dateConsult;
	}

	public void setDateConsult(Date dateConsult) {
		this.dateConsult = dateConsult;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getConsultationPrice() {
		return consultationPrice;
	}

	public void setConsultationPrice(Double consultationPrice) {
		this.consultationPrice = consultationPrice;
	}

	public Double getRebate() {
		return rebate;
	}

	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}

}
