package com.sarthak.jpa.association.oneToOne;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// below code is write considering the owner of relationship is Student and we're no getting any input from other end
@Service(value = "serviceMapping")
public class ImplServiceMapping {
//	This Dependency Injection is for Student is owner of relationship
	@Autowired
	private InterRepositoryMapping repoMapping;
	
//	below Dependecy Injection is for In case of LoginDetail is owner of relationship
	@Autowired
	private InterRepositoryMapping1 repoMapping1;
	
	
//	Now the below method is for bi-directional
	public void saveEntity() {
//		creation of LoginDetail object and setting it to the Student object
		LoginDetail loginDetail=new LoginDetail("saroBoss","saro123213");
//		creation of student object
		Student student1=new Student("Sarthak Nalage","sarthaknalage@gmail.com",loginDetail);
		loginDetail.setStudent(student1);
//		saving the current entity
//		owner of relationship is Student so we have to do all operations student POV
		Student savedStudent=this.repoMapping.save(student1);
		System.out.println("Student object is successfully saved !!!");
		System.out.println(savedStudent);
		
	}
	public void findById(Integer id) {
		System.out.println("call comes here finder method");
		Optional<Student> getStudent=this.repoMapping.findById(id);
		if(getStudent.isPresent()) {
			Student fetchStudent=getStudent.get();
			System.out.println(fetchStudent);
		}
		
	}
	
//	&&*** Now the owner of relationship is LoginDetail so all operations are done according to LoginDetail
	public void findByLoginId(Integer id) {
		Optional<LoginDetail> loginDetail1=this.repoMapping1.findById(1);
		if(loginDetail1.isPresent()) {
			LoginDetail loginDetail=loginDetail1.get();
			System.out.println(loginDetail);
		}
	}
}
