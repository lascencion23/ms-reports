package com.everis.msreports.entity;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.everis.msreports.entity.customer.Customer;
import com.everis.msreports.entity.customer.Customer.DocumentType;
import com.everis.msreports.entity.customer.SubType;
import com.everis.msreports.entity.customer.SubType.EnumSubType;
import com.everis.msreports.entity.customer.TypeCustomer.EnumTypeCustomer;
import com.everis.msreports.entity.customer.TypeCustomer;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataMongoTest
public class ReportTest {

	@Autowired
	private ReactiveMongoTemplate template;
	
	@Test
	public void persist() throws Exception {
		
		SubType sc = new SubType("0", EnumSubType.NORMAL);
		
		TypeCustomer tc = new TypeCustomer("0", EnumTypeCustomer.PERSONAL,sc);
		
		Customer cs = new Customer("0", "luis", "ascencion", tc, DocumentType.DNI, "71380976", new Date(), "das");
		
		ReportGeneral st = new ReportGeneral(null, null,null,null,null);
		Mono<ReportGeneral> save = this.template.save(st);
		StepVerifier
			.create(save)
			.expectNextMatches(match -> 
				match.getCustomer().getDocumentType().equals("DNI") &&
				match.getCurrentsAccounts() != null && 
				match.getFixedTermAccounts() != null && 
				match.getCreditCards().equals("List") &&
				match.getCustomer().getTypeCustomer().getSubType().getValue().equals(EnumSubType.NORMAL))
			.verifyComplete();
	}
	
}
