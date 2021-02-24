package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.client;
import com.example.demo.repository.clientRepository;

@Controller
public class ClientController {

	@Autowired
	private clientRepository clientrepo;
	
	@GetMapping("/clients")
	public String clientsfideles(Model model) {
		model.addAttribute("clients",clientrepo.findAll());
		return "allClients";
	}
	
	@GetMapping("/addc")
	public String addForm(client client) {
		return "addClient";
	}
	
	
	@PostMapping("addClient")
	public String addClient(client client,Model model) {
		clientrepo.save(client);		
		return "addvoitureClient";
	}
	
	@GetMapping("/deleteC/{id}")
	public String deteteClient(@PathVariable("id") String id, Model model) {
		client client=clientrepo.findById(Integer.parseInt(id)).get();
		clientrepo.delete(client);
		model.addAttribute("clients", clientrepo.findAll());
		return "allClients";
	}
}
