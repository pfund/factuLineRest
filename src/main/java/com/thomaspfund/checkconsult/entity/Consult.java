package com.thomaspfund.checkconsult.entity;

import java.util.Date;

import org.bson.types.ObjectId;

public class Consult {

	private String id;
	
	private Double montant;
	
	private Date dateConsult;
	
	private Double rabais;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDateConsult() {
		return dateConsult;
	}

	public void setDateConsult(Date dateConsult) {
		this.dateConsult = dateConsult;
	}

	public Double getRabais() {
		return rabais;
	}

	public void setRabais(Double rabais) {
		this.rabais = rabais;
	}
	
	
}
