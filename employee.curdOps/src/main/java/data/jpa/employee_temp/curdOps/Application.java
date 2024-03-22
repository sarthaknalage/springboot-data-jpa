package data.jpa.employee_temp.curdOps;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import data.jpa.employee_temp.curdOps.model.Employee;
import data.jpa.employee_temp.curdOps.service.ImplServiceEmployee;

@SpringBootApplication
public class Application implements ApplicationRunner{
	
	@Autowired
	ImplServiceEmployee implServiceEmployee;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
//		Employee emp=new Employee(1, "sarthak", 238238.23);
//		System.out.println(implServiceEmployee.save(emp));
		System.out.println(implServiceEmployee.findById(1));
	}

}
