package com.sarthak.jpa.association;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sarthak.jpa.association.oneToOne.ControllerMapping;

@SpringBootApplication()
public class AssociationApplication implements ApplicationRunner{

	@Autowired
	ControllerMapping controllerMapping;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(AssociationApplication.class, args);
//		******&&&&&&&$$$$$$$$$$$ Below code is for performing the operations on Post and
//		comments and understanding of oneToMany Association
		oneToMayController oneMController=context.getBean(oneToMayController.class);
		System.out.println("Calling the Logic for saving the post Entity!!");
//	 This is for saving the post entity
//		oneMController.saved();
//		code for reading the entity
//		oneMController.read(1);
//		oneMController.update();
		
//		Now time to delete the Entity
//		Note: even though you mention cascadeType as All but it doesn't truncate child table it 
//		only makes the fk_columns as null so they becomes orphan as no relation
		oneMController.delete(1);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("cmnd line runner");
//		** saving the entity into the database
//		this.controllerMapping.runAndSave();
		
//		***find by id of student 
//		this.controllerMapping.findById(1);
		
//		** find by Login Detail ID
//		this.controllerMapping.findLoginDetailById(1);
		
		
	}

}
