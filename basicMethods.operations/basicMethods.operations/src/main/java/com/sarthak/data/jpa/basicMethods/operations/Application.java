package com.sarthak.data.jpa.basicMethods.operations;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.sarthak.data.jpa.basicMethods.operations.model.Customer;
import com.sarthak.data.jpa.basicMethods.operations.service.CustomerServiceInterface;

import org.springframework.data.domain.Sort.Order;

@SpringBootApplication
public class Application implements ApplicationRunner{
	@Autowired
	CustomerServiceInterface implCustomerServiceInterface;

		 void pagination() {
			final int pageSize=2;
			boolean flag=true;
			int i=0;
			Scanner scanner=new Scanner(System.in);
			while(flag) {
				PageRequest pageRequest= PageRequest.of(i, pageSize);
				i++;
				org.springframework.data.domain.Page<Customer> page= implCustomerServiceInterface.findAll(pageRequest);
				page.stream().forEach(System.out::println);
				System.out.println("Move to next page "+i);
				flag=scanner.nextBoolean();
				
			}
		}
		 
		 public  void printCustomerByName(String name) {
			Iterable<Customer> itr= implCustomerServiceInterface.getCustomerByName(name);
			Iterator<Customer> iterator=itr.iterator();
			while(iterator.hasNext()) {
				Customer customer=iterator.next();
				System.out.println(customer);
			}
		 }
		 
		 public void printPartialCustomerListGreaterThanID(Integer id) {
			 this.implCustomerServiceInterface.getCustomerList(id).stream().forEach((Object[]ary)->{
				 System.out.println(ary[0]+" "+ary[1]);
			 });
		 }
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Customer customer=new Customer("RajeShahi", 435465565L, "sartgeage@gamil.com");
		implCustomerServiceInterface.save(customer);
		Customer customer1=new Customer("Ruturaj", 9881601399L, "ruturaj_nalage2123@gamil.com");
		Customer customer2=new Customer("Rupali", 94030232066L, "rupali_nalage@gamil.com");
		Customer customer3=new Customer("Sanjay", 9921757571L, "sanjaynalage_1@gamil.com");
		Customer customer4=new Customer("Manikrao", 9403234324L, "manki_nal@gamil.com");
		Customer customer5=new Customer("Satyabhama", 9120122166L, "satya_knalage@gamil.com");
		List<Customer>listCustomer=List.of(customer1,customer2,customer3,customer4,customer5);
		System.out.println("Saving the List of Customers");
		implCustomerServiceInterface.saveAll(listCustomer).stream().forEach(System.out::println);
			
		
			System.out.println("Showing the Data in pagination format!!!");
			final int pageSize=2;
			boolean flag=true;
			int i=0;
			Scanner scanner=new Scanner(System.in);
			Long totalRecord=implCustomerServiceInterface.count();
			int limit=(int) (totalRecord/pageSize);
			if(totalRecord%pageSize!=0) {
				limit++;
			}
			System.out.println(limit);
			while(flag && i<limit) {
				PageRequest pageRequest= PageRequest.of(i, pageSize);
				i++;
				org.springframework.data.domain.Page<Customer> page= implCustomerServiceInterface.findAll(pageRequest);
				page.stream().forEach(System.out::println);
				System.out.println("Move to next page "+i);
				flag=scanner.nextBoolean();
				
			}
			
			System.out.println("Doing the Sorting by columns names values!!!");
			Sort sort=Sort.by(Sort.Direction.DESC,"custName");
			implCustomerServiceInterface.findAll(sort).stream().forEach(System.out::println);
//			if the case that you're property has same value then you can go with
			Order order=Order.by("custId");
			Order order1=Order.by("custName");
			List<Order>listOrder= List.of(order,order1);
			Sort sort1= Sort.by(listOrder);
			implCustomerServiceInterface.findAll(sort1);
			
			System.out.println(" **** Finder Method ****");
			printCustomerByName("Sarthak");
		
		System.out.println("**** Printing List of Customer greater than id with JPA QL ****");
//		partial Object with custom JPQL 
		printPartialCustomerListGreaterThanID(4);
		
	}
	
}
