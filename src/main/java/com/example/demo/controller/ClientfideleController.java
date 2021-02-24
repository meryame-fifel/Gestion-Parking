package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.ClientFidele;
import com.example.demo.repository.ClientfideleRepository;

@Controller
public class ClientfideleController {

	@Autowired
	private ClientfideleRepository clientRepo;
	
	@GetMapping("/clientsfideles")
	public String clientsfideles(Model model) {
		model.addAttribute("clientsfideles",clientRepo.findAll());
		return "clientsfideles";
	}
	
	@GetMapping("/addCf")
	public String addForm(ClientFidele clientfidele) {
		return "addClientF";
	}
	
	@PostMapping("addClientF")
	public String addClientF(ClientFidele clientfidele,Model model) {
		clientRepo.save(clientfidele);		
		return "message";
	}
	
	@GetMapping("/deleteCf/{id}")
	public String deteteClientF(@PathVariable("id") String id, Model model) {
		ClientFidele clientfidele=clientRepo.findById(Integer.parseInt(id)).get();
		clientRepo.delete(clientfidele);
		model.addAttribute("clientsfideles", clientRepo.findAll());
		return "clientsfideles";
	}
	@GetMapping("/searchCf")
	public String findClientF(Model model, @RequestParam(name="cin",defaultValue="") String cin) {
		model.addAttribute("clientsfideles", clientRepo.findByCIN(cin));
		model.addAttribute("cin", cin);
		return "clientsFidelesFound";
	}
}
