package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Place;
import com.example.demo.entity.Vehicule;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.repository.VehiculeRepository;

@Controller
public class PlaceController {

	@Autowired
	private PlaceRepository placeRepo;
	@Autowired
	private VehiculeRepository vehiculeRepo;
	
	//affichage
	@GetMapping("/places")
	public String places(Model model) {
		model.addAttribute("places",placeRepo.findAll());
		return "places";
	}
	@GetMapping("/placeclient")
	public String placeclient(Model model) {
		model.addAttribute("places",placeRepo.findAll());
		return "placeClients";
	}
	//ajout 
	@GetMapping("/addP")
	public String addForm(Place place,Model model) {
		model.addAttribute("vehicules",vehiculeRepo.findByPlaceIsNull());
		return "addPlace";
	}
	
	@PostMapping("addPlace")
	public String addPlace(Place place, Model model, @RequestParam(name = "vehicule_id") String vehicule_id) {
		Vehicule v = vehiculeRepo.findById(Integer.parseInt(vehicule_id));
		place.setVehicule(null);
		v.setPlace(null);
		placeRepo.save(place);
		model.addAttribute("places", placeRepo.findAll());
		model.addAttribute("vehicule", vehiculeRepo.findAll());
		
		return "places";
	}

	@GetMapping("/deleteP/{id}")
	public String detetePlace(@PathVariable("id") String id, Model model) {
		Place place=placeRepo.findById(Integer.parseInt(id)).get();
		placeRepo.delete(place);
		model.addAttribute("places", placeRepo.findAll());
		return "places";
	}
	@GetMapping("/viderPlace/{id}")
	public String viderplace(@PathVariable("id") String id,Model model) {
		Place place=placeRepo.findById(Integer.parseInt(id)).get();
		place.setVehicule(null);
		place.setDisponibilite(true);
		Vehicule v=place.getVehicule();
		placeRepo.save(place);
		model.addAttribute("places", placeRepo.findAll());
		return "places";
	}
	@GetMapping("/editP/{id}")
	public String showUpdateuserForm(@PathVariable("id") String id,Model model ) {
		Place place=placeRepo.findById(Integer.parseInt(id)).get();
		model.addAttribute("vehicules",vehiculeRepo.findByPlaceIsNull());
		model.addAttribute("place",place);
		return "updatePlace";
	}
	@PostMapping("/updateP/{id}")
	 public String updateUser(@PathVariable("id")String id, Place place, Model model, @RequestParam(name = "vehicule_id") String vehicule_id) { 
		Vehicule v = vehiculeRepo.findById(Integer.parseInt(vehicule_id));
		place.setVehicule(v);
		v.setPlace(place);
		placeRepo.save(place);

		model.addAttribute("vehicules",vehiculeRepo.findByPlaceIsNull());
	  model.addAttribute("places", placeRepo.findAll());
	  
	  return "places";
	  }
	 //les places vides
	@GetMapping("/placesVides")
	public String placesVides(Model model) {
		model.addAttribute("places", placeRepo.findByDisponibilite(true));
		return "emptyPlaces";
	}
	@GetMapping("/placeclientsVides")
	public String placeclientsVides(Model model) {
		model.addAttribute("places", placeRepo.findByDisponibilite(true));
		return "placeclientsVides";
	}
	@GetMapping("/positionVehicule")
	public String placeduvehicule(Model model,@RequestParam(name="idv",defaultValue="") String idv) {
	Vehicule v=vehiculeRepo.findById(Integer.parseInt(idv));
		model.addAttribute("places", placeRepo.findByVehicule(v));
		model.addAttribute("idv",idv);
		return "positionVehicule";
	}	
}
