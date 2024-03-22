package data.jpa.employee_temp.curdOps.service;

import java.util.Optional;

import data.jpa.employee_temp.curdOps.model.Employee;

public interface IServiceEmployee {
	public Employee save(Employee employee);
	
	public Iterable<Employee> saveAll(Iterable<Employee> entities);
	
	public Employee findById(Integer id);
	
	public boolean existsById(Integer id);
	
	Iterable<Employee> findAll();
	
	Iterable<Employee> findAllById(Iterable<Integer> ids);
	
	long count();
	
	Boolean deleteById(Integer id);
	
	Boolean delete(Employee entity);

	void deleteAllById(Iterable<Integer> ids);

	void deleteAll(Iterable<Employee> entities);
	
	void deleteAll();
}
