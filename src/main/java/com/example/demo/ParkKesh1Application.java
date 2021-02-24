package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Parking;
import com.example.demo.repository.ParkingRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class ParkKesh1Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	ParkingRepository parkingRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ParkKesh1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(userRepo.count());
		
		
		//Parking p1=new Parking(1,"KechparK",150,20,"Prive","GUELIZ",23,"MARRAKECH","0661006166","0524300030");
		//this.parkingRepo.save(p1);
		
	}
 
}
