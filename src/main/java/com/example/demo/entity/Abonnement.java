package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Abonnement")
@Data
public class Abonnement {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private int nbjour;
	private int tarif;
	
	
	public Abonnement() {
		super();
	}
	public Abonnement(String description, int nbjour, int tarif) {
		super();
		this.description = description;
		this.nbjour = nbjour;
		this.tarif = tarif;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbjour() {
		return nbjour;
	}
	public void setNbjour(int nbjour) {
		this.nbjour = nbjour;
	}
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	
	
}
