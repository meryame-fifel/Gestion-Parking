package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;
	//affichage
	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("users",userRepo.findAll());
		return "users";
	}
	
	//ajout
	@GetMapping("/addU")
	public String addForm(User user) {
		return "addUser";
	}
	
	@PostMapping("addUser")
	public String addutilisateur(User user,Model model) {
		userRepo.save(user);
		model.addAttribute("users", userRepo.findAll());
		return "users";
	}
	//modification
		@GetMapping("/editU/{id}")
		public String showUpdateuserForm(@PathVariable("id") String id,Model model ) {
			User user=userRepo.findById(Integer.parseInt(id)).get();
			model.addAttribute("user", user);
			return "updateUser";
		}
		@PostMapping("/updateU/{id}")
		 public String updateUser(@PathVariable("id")String id, User user, Model model) { 
		  userRepo.save(user);
		  model.addAttribute("users", userRepo.findAll());
		  return "users";
		  }
		 
	//suppression
	@GetMapping("/deleteU/{id}")
	public String deteteUser(@PathVariable("id") String id, Model model) {
		User user=userRepo.findById(Integer.parseInt(id)).get();
		userRepo.delete(user);
		model.addAttribute("users", userRepo.findAll());
		return "users";
	}
	
	//recherche
	@GetMapping("/findU")
	public String findUsers(Model model,@RequestParam(name="nom",defaultValue="")String nom) {
		model.addAttribute("users", userRepo.findByNom(nom));
		model.addAttribute("nom", nom);
		
		return "usersFound";
	}
	
}
