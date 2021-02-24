package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Entity
@Table(name="Vehicule")
public class Vehicule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String matricule;
	private String couleur;
	private String marque;
	private int modele;
	@OneToOne(mappedBy = "vehicule", fetch = FetchType.LAZY)
	@JoinColumn(name="place_id")
	private Place place;
	/*
	 * @OneToOne private Place place;
	 */
	
	public Vehicule() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getModele() {
		return modele;
	}
	public void setModele(int modele) {
		this.modele = modele;
	}
	

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	public Vehicule(int id, String matricule, String couleur, String marque, int modele, Place place) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.couleur = couleur;
		this.marque = marque;
		this.modele = modele;
		this.place = place;
	}
	@Override
	public String toString() {
		return  matricule ;
	}
	
	
}
