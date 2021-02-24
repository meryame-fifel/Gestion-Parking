package com.example.demo.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="parking")
@Data
public class Parking {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private int nbPlace;
	private int nbPlaceVides;
	private String type;
	private String quartier;
	private int num;
	private String ville;
	private String tel;
	private String fixe;
	
	
	
	public Parking(Integer id, String nom, int nbPlace, int nbPlaceVides, String type, String quartier, int num,
			String ville, String tel, String fixe) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbPlace = nbPlace;
		this.nbPlaceVides = nbPlaceVides;
		this.type = type;
		this.quartier = quartier;
		this.num = num;
		this.ville = ville;
		this.tel = tel;
		this.fixe = fixe;
	}

	/*
	 * @OneToMany(mappedBy="parking") private Set<Place> places;
	 */
	

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFixe() {
		return fixe;
	}

	public void setFixe(String fixe) {
		this.fixe = fixe;
	}

	public Parking(Integer id, String nom, int nbPlace, int nbPlaceVides, String type, String quartier, int num,
			String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbPlace = nbPlace;
		this.nbPlaceVides = nbPlaceVides;
		this.type = type;
		this.quartier = quartier;
		this.num = num;
		this.ville = ville;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public int getNbPlaceVides() {
		return nbPlaceVides;
	}

	public void setNbPlaceVides(int nbPlaceVides) {
		this.nbPlaceVides = nbPlaceVides;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Parking() {
		super();
	}
	
	
}
