package com.shopping.Entities;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGeneration implements IdentifierGenerator {

	public int generateProductId() {
		Random random=new Random();
		return random.nextInt(99999);
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		return 556+this.generateProductId();
	}

}
