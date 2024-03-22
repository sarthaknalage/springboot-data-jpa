package data.jpa.employee_temp.curdOps.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.jpa.employee_temp.curdOps.dao.InterfaceDaoEmployee;
import data.jpa.employee_temp.curdOps.model.Employee;

@Service
public class ImplServiceEmployee implements IServiceEmployee{
	
	@Autowired
	InterfaceDaoEmployee interfaceDaoEmployee;
	
	@Override
	public Employee save(Employee employee) {
		if(employee!=null) {
			
			return interfaceDaoEmployee.save(employee);
		}
		return null;
	}

	@Override
	public Iterable<Employee> saveAll(Iterable<Employee> entities) {
		List<Employee> collection=(List) entities;
		if(collection.size()==1) {
			 this.save(collection.get(0));
			 return entities;
		}
		return interfaceDaoEmployee.saveAll(entities);
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
			Optional<Employee> opt=interfaceDaoEmployee.findById(id);
			
		return opt.isPresent()?(Employee)opt.get():null;
	}

	@Override
	public boolean existsById(Integer id) {
		return (id!=null)?interfaceDaoEmployee.existsById(id):false;
	}

	@Override
	public Iterable<Employee> findAll() {
		
		return interfaceDaoEmployee.findAll();
	}

	@Override
	public Iterable<Employee> findAllById(Iterable<Integer> ids) {
		return interfaceDaoEmployee.findAllById(ids);
	}

	@Override
	public long count() {
		return interfaceDaoEmployee.count();
	}

	@Override
	public Boolean deleteById(Integer id) {
		if(id!=null) {
			interfaceDaoEmployee.deleteById(id);
		return !interfaceDaoEmployee.existsById(id);
	}
		return false;
	}
	

	@Override
	public Boolean delete(Employee entity) {
		if(entity!=null) {
			interfaceDaoEmployee.delete(entity);
			return !interfaceDaoEmployee.existsById(entity.getEmpId());
		}
		return false;
	}

	@Override
	public void deleteAllById(Iterable<Integer> ids) {
		if(ids!=null) {
		List<Integer> list=new ArrayList<>((Collection)ids);
		if(list.size()==1) {
			interfaceDaoEmployee.deleteById(list.get(0));
			
		}else {
			interfaceDaoEmployee.deleteAllById(list);
		}
		
		}
		return;
		
	}

	@Override
	public void deleteAll(Iterable<Employee> entities) {
		 interfaceDaoEmployee.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		interfaceDaoEmployee.deleteAll();
	}

}
