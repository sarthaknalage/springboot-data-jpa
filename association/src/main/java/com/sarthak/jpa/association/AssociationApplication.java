package com.sarthak.jpa.association;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sarthak.jpa.association.oneToOne.ControllerMapping;

@SpringBootApplication()
public class AssociationApplication implements ApplicationRunner {

	@Autowired
	ControllerMapping controllerMapping;
	
	public static void main(String[] args) {
		SpringApplication.run(AssociationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("cmnd line runner");
//		** saving the entity into the database
		this.controllerMapping.runAndSave();
		
//		***find by id of student 
		this.controllerMapping.findById(1);
		
//		** find by Login Detail ID
		this.controllerMapping.findLoginDetailById(1);
	}

}
