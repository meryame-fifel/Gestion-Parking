package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Place;
import com.example.demo.entity.Vehicule;

public interface PlaceRepository extends JpaRepository<Place, Integer>{
	
	List<Place> findByDisponibilite(boolean dispo);
	List<Place> findByVehicule(Vehicule v);

}
