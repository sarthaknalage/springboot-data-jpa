package com.sarthak.jpa.association.oneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class ControllerMapping {

	@Autowired
	private ImplServiceMapping serviceMapping;

	public void runAndSave() {
		System.out.println("caaling the save entity method of service implementation");
		this.serviceMapping.saveEntity();
	}
	public void findById(Integer id) {
		System.out.println("Getting the information of student with ID of +"+id);
		this.serviceMapping.findById(id);
	}
	
//	In case of Login Detail is owner of relationship
	public void findLoginDetailById(Integer id) {
		System.out.println("Getting the Login Detail information from db");
		this.serviceMapping.findByLoginId(id);
	}
	
}
