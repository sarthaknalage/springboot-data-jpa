package com.spring.jpa.sarthak.custom.query.jpql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jpa.sarthak.custom.query.jpql.customerService.InterCustomerService;
import com.spring.jpa.sarthak.custom.query.jpql.persisten.customer.InterCutomerPersistent;

@SpringBootApplication
public class Application implements ApplicationRunner{
//	you can autowired with impl class by it Interface name because 
	/*his is because Spring scans for components annotated with @Component, @Service, @Repository, etc., and when it encounters an interface annotated with @Service, it looks for its implementation and wires that implementation wherever the interface is autowired. So, in the controller, MyService is autowired, and since MyServiceImpl is the implementation of MyService, it gets injected.
	 * 
	 */
	@Autowired
	private InterCustomerService interCustomer;
	@Autowired
	private InterCutomerPersistent interCustomerPersistent;
	public void readPartialCustomerObject() {
		List<Object[]> customerDetails= this.interCustomer.getCustomerPartilaDetails();
		customerDetails.stream().forEach(object->{
			System.out.println(object[0]+" "+object[1]);
		});
	}
	public void customerGreaterThanID(Integer id) {
		List<Object[]> customerDetails= this.interCustomer.getCustomerDetailsGreaterID(id);
		customerDetails.stream().forEach(object->{
			System.out.println(object[0]+" "+object[1]);
		});
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {

		readPartialCustomerObject();
//		getting the required details of customer greater than id 4
		customerGreaterThanID(4);
	}
	
	
}
