package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ClientFidele;

public interface ClientfideleRepository  extends JpaRepository<ClientFidele, Integer> {

	List<ClientFidele> findByCIN(String cin);
}
