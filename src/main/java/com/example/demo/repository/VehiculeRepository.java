package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Place;
import com.example.demo.entity.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer>{

	 List<Vehicule> findByMatricule(String matricule);
	 Vehicule findById(int id);
	 List<Vehicule> findByPlaceIsNull();

	/*
	 * @Query("select v from vehicule v where v.place=: place") List<Vehicule>
	 * nonparkedvehicule(Place place);
	 */
}
