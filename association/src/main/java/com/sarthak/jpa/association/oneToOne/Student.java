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
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="std_id")
	private Integer studentId;
	
	@Column(name="std_name")
	private String studentName;
	
	@Column(name="std_mail")
	private String studentMail;
	
	@OneToOne(targetEntity = LoginDetail.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_log_id")// this will created in source entity one to one unidirectional
	private LoginDetail loginDetail;
	

	public Student() {
		
	}

	public Student(String studentName, String studentMail, LoginDetail logDetail) {
		super();
		this.studentName = studentName;
		this.studentMail = studentMail;
		this.loginDetail=logDetail;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMail() {
		return studentMail;
	}

	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}
	
	public LoginDetail getLoginDetail() {
		return loginDetail;
	}
	
	public void setLoginDetail(LoginDetail loginDetail) {
		this.loginDetail = loginDetail;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMail=" + studentMail
				+ ", loginDetail=" + this.currentLoginDetailInfo() + "]";
	}
	
	private String currentLoginDetailInfo() {
		return "LoginDetail [loginId=" + this.loginDetail.getLoginId() + ", loginUsername=" + this.loginDetail.getLoginUsername() + ", loginPassword="
				+ this.loginDetail.getLoginPassword() ;
	}
	
}
