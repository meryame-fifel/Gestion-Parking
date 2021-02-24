package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Parking;
import com.example.demo.entity.Place;
import com.example.demo.entity.User;
import com.example.demo.repository.AbonnementRepository;
import com.example.demo.repository.ClientfideleRepository;
import com.example.demo.repository.ParkingRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehiculeRepository;

@Controller
public class ParkingController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PlaceRepository placeRepo;
	@Autowired
	AbonnementRepository abonnementRepo;
	@Autowired 
	VehiculeRepository vehiculeRepo;
	@Autowired 
	ClientfideleRepository clientRepo;
	@Autowired
	ParkingRepository parkingRepo;
	
	
	@GetMapping("/")
	public String indexform() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String parkings(Model model) {
		//model.addAttribute("parkings",parkingRepo.findAll());
		//model.addAttribute("sum",userRepo.count());
		long sum=userRepo.count();
		model.addAttribute("sum",sum);
		model.addAttribute("allplaces", placeRepo.count());	
		model.addAttribute("allabonnements", abonnementRepo.count());
		model.addAttribute("allvehicules", vehiculeRepo.count());
		model.addAttribute("allclientsf",clientRepo.count());
		return "dashboard";
	}
	@GetMapping("/profil")
	public String parkingprofil(Model model) {
		Parking parking = parkingRepo.findById(1).get();
		model.addAttribute("parking", parking);
		model.addAttribute("clientsfideles",clientRepo.findAll());
		return "profil";
	}
	@GetMapping("/localisation")
	public String loca() {
		return "localisation";
	}
	@GetMapping("/profilclient")
	public String parkingclient(Model model) {
		Parking parking = parkingRepo.findById(1).get();
		model.addAttribute("parking", parking);
		return "profilclient";
	}
	
	@GetMapping("/editParking/{id}")
	public String showUpdateForm( Model model) {
		Parking parking = parkingRepo.findById(1).get();
		model.addAttribute("parking", parking);
		return "updateParking";
	}

	@PostMapping("/updateParking/{id}")
	public String updateParking( Parking parking, Model model) {
		parkingRepo.save(parking);
		model.addAttribute("parking", parking);
		return "profil";
	}
	
	
}
