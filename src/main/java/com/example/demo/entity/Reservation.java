package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Reservation")
@Data
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date dateDebut;
	private String duree;
}
