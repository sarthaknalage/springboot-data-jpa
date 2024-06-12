package com.sarthak.data.id.generator.cusidgene.logic;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.sarthak.data.id.generator.entity.Banker;

public class BankerIdGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String id=getUniqueIdData(object);
		
		return id;
	}
	
	public String getUniqueIdData(Object object) {
		String finalId=null;
		try {
			Banker banker=(Banker)object;
			String namefield=banker.getBankerName().substring(0, 3);
			String mobField=banker.getBankerMobNo().toString().substring(6);
			finalId= namefield+mobField;
			System.out.println(finalId);
		}catch (Exception e) {
			System.out.println("Exception is occured during custom id generator !!");
			System.out.println(e.getLocalizedMessage());
		}
		return finalId;
	}

}
