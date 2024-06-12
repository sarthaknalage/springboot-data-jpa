package com.sarthak.data.id.generator.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "banker")
public class Banker {

	@Id
	@Column(name = "banker_id")
	@GeneratedValue(generator = "bank_id_generator")
	@GenericGenerator(name = "bank_id_generator", strategy = "com.sarthak.data.id.generator.cusidgene.logic.BankerIdGenerator")
	private String bankerId;
	
	@Column(name="banker_name")
	private String bankerName;
	
	@Column(name="banker_mob")
	private Long bankerMobNo;
	
	@Column(name = "banker_mail")
	private String bankerMailID;
	
	public Banker() {
		
	}

	public Banker(String bankerName, Long bankerMobNo, String bankerMailID) {
		super();
		this.bankerName = bankerName;
		this.bankerMobNo = bankerMobNo;
		this.bankerMailID = bankerMailID;
	}

	
	public String getBankerId() {
		return bankerId;
	}
	@Override
	public String toString() {
		return "Banker [bankerId=" + bankerId + ", bankerName=" + bankerName + ", bankerMobNo=" + bankerMobNo
				+ ", bankerMailID=" + bankerMailID + "]";
	}

	public String getBankerName() {
		return bankerName;
	}

	public void setBankerName(String bankerName) {
		this.bankerName = bankerName;
	}

	public Long getBankerMobNo() {
		return bankerMobNo;
	}

	public void setBankerMobNo(Long bankerMobNo) {
		this.bankerMobNo = bankerMobNo;
	}

	public String getBankerMailID() {
		return bankerMailID;
	}

	public void setBankerMailID(String bankerMailID) {
		this.bankerMailID = bankerMailID;
	}
	
}
