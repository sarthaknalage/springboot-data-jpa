package data.jpa.employee_temp.curdOps.dao;

import org.springframework.data.repository.CrudRepository;

import data.jpa.employee_temp.curdOps.model.Employee;

//@Repository ** no need to add this Annotations
public interface InterfaceDaoEmployee extends CrudRepository<Employee, Integer>{
		
}
