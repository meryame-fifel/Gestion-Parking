package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Vehicule;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.repository.VehiculeRepository;

@Controller
public class VehiculeController {

	@Autowired
	private VehiculeRepository vehiRepo;
	@Autowired
	private PlaceRepository placeRepo;
	
	@GetMapping("/vehicules")
	public String vehicules(Model model) {
		model.addAttribute("vehicules",vehiRepo.findAll());
		return "vehicules";
	}
	@GetMapping("/reservations")
	public String reservation(Model model) {
		model.addAttribute("vehicules",vehiRepo.findAll());
		return "reservations";
	}
	
	@GetMapping("/search")
	public String findVehicule(Model model, @RequestParam(name="matricule",defaultValue="") String matricule) {
		model.addAttribute("vehicules", vehiRepo.findByMatricule(matricule));
		model.addAttribute("matricule", matricule);
		return "vehiculesFound";
	}
	
	//add
	@GetMapping("/addV")
	public String addForm(Vehicule vehicule) {
		return "addVehicule";
	}
	
	@PostMapping("addVehicule")
	public String addVehicule(Vehicule vehicule,Model model) {
		vehiRepo.save(vehicule);
		model.addAttribute("vehicules", vehiRepo.findAll());
		return "vehicules";
	}
	@PostMapping("addvoitureClient")
	public String addvoiture(Vehicule vehicule,Model model) {
		vehiRepo.save(vehicule);
		model.addAttribute("places", placeRepo.findByDisponibilite(true));
		return "placeclientsVides";
	}
	
	@GetMapping("/deleteV/{id}")
	public String deteteVehicule(@PathVariable("id") String id, Model model) {
		Vehicule vehicule=vehiRepo.findById(Integer.parseInt(id));
		vehiRepo.delete(vehicule);
		model.addAttribute("vehicules", vehiRepo.findAll());
		return "vehicules";
	}
}
