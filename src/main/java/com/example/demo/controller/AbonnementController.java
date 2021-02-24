package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Abonnement;
import com.example.demo.repository.AbonnementRepository;

@Controller
public class AbonnementController {

	@Autowired
	private AbonnementRepository abonRepo;
	
	@GetMapping("/abonnements")
	public String abonnements(Model model) {
		model.addAttribute("abonnements",abonRepo.findAll());
		return "abonnements";
	}
	@GetMapping("/abonnementsClient")
	public String abonnementsclient(Model model) {
		model.addAttribute("abonnements",abonRepo.findAll());
		return "abonnementsClient";
	}
	
	@GetMapping("/addA")
	public String addForm(Abonnement abonnement) {
		return "addAbonnement";
	}
	
	@PostMapping("addAbonnement")
	public String addAbonnement(Abonnement abonnement,Model model) {
		abonRepo.save(abonnement);
		model.addAttribute("abonnements", abonRepo.findAll());
		return "abonnements";
	}
	@GetMapping("/deleteA/{id}")
	public String detetePlace(@PathVariable("id") String id, Model model) {
		Abonnement abonnement=abonRepo.findById(Integer.parseInt(id)).get();
		abonRepo.delete(abonnement);
		model.addAttribute("abonnements", abonRepo.findAll());
		return "abonnements";
	}
	
	@GetMapping("/editA/{id}")  
	public String showUpdateForm(@PathVariable("id") String id, Model model) {   
		Abonnement abonnement = abonRepo.findById(Integer.parseInt(id)).get();     
		model.addAttribute("abonnement", abonnement);   
		return "updateAbonnement";  
	}
	
	@PostMapping("/updateA/{id}")  
	public String updateAuteur(@PathVariable("id") String id,Abonnement abonnement, Model model) { 
		abonRepo.save(abonnement);   
		model.addAttribute("abonnements", abonRepo.findAll());   
		return "abonnements";  
	}
	@GetMapping("/view/{id}")  
	public String show(@PathVariable("id") String id, Model model) {   
		Abonnement abonnement = abonRepo.findById(Integer.parseInt(id)).get();     
		model.addAttribute("abonnement", abonnement);   
		return "viewAbonnement";  
	}
}
