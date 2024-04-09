package com.sarthak.jpa.association.oneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_detail")
public class LoginDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
	private Integer loginId;
	
	@Column(name="login_username")
	private String loginUsername;
	
	@Column(name="login_pass")
	private String loginPassword;
	
	// for two way databinding
	@OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name = "fk_std_id")bcz it is created inside the source entity
	private Student student;
	
	public LoginDetail() {
		
	}
	public LoginDetail(String user, String pass) {
		this.loginUsername=user;
		this.loginPassword=pass;
	}
	
	public LoginDetail(String loginUsername, String loginPassword, Student student) {
		super();
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
		this.student = student;
	}
	public Integer getLoginId() {
		return loginId;
	}
	
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "LoginDetail [loginId=" + loginId + ", loginUsername=" + loginUsername + ", loginPassword="
				+ loginPassword + ", student=" + this.currentStudentInfo() + "]";
	}
	
	// this utility method for avoiding the problem of circular dependency which can be encountered in case of findById(0) for bi-directional mapping
	private String currentStudentInfo() {
		return "Student [studentId=" + this.student.getStudentId() + ", studentName=" + this.student.getStudentName() + ", studentMail=" + this.student.getStudentMail();
	}
	
}
