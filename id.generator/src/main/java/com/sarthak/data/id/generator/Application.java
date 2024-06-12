package com.sarthak.data.id.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sarthak.data.id.generator.entity.Banker;
import com.sarthak.data.id.generator.entity.Product;
import com.sarthak.data.id.generator.service.ISeriveProduct;
import com.sarthak.data.id.generator.service.ImplBankerService;

@SpringBootApplication
public class Application implements ApplicationRunner{
	@Autowired
	 private  ISeriveProduct implServiceProduct;
	
	@Autowired
	private ImplBankerService bankerService;
	
	public static void main(String[] args) {
		System.out.println("*****First Call");
		SpringApplication.run(Application.class, args);
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("****Second call");
//		Product Object Creation and insertion into the db
//		Product prd=new Product("Moto fusion 121",32343.213F);
//		System.out.println("Saving the Product");
//		System.out.println(implServiceProduct.saveAndFlush(prd));
//		System.out.println("Operation is done!!!");
		
		System.out.println("Saving the Banker data !!! with the custome Id generator");
		System.out.println("*** creating Banker entity ***");
		Banker entity=new Banker("Sarthak", 9403073066L, "sarthaknalage@gmail.com");
		System.out.println("&&& saving the entity &&&");
//		this.bankerService.saveAndFlush(entity);
		System.out.println("Entity saved successfully !!!");
		System.out.println("*** Fetching the saved Entity ***");
		System.out.println(this.bankerService.findById("Sar3066"));
	}

}
