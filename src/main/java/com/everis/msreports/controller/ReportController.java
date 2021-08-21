package com.everis.msreports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.msreports.entity.Customer;
import com.everis.msreports.entity.ReportGeneral;
import com.everis.msreports.service.ReportService;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportService service;

	@GetMapping("/general/{id}")
	public Mono<ReportGeneral> reportGeneral(@PathVariable String id) {

		Mono<Customer> customer = service.findCustomerByIdCustomer(id);

		Mono<ReportGeneral> report =  customer.flatMap( cus -> service.findCreditCardByIdCustomer(cus.getId()).collectList()
											  .flatMap( credit -> service.findCurrentAccountByIdCustomer(cus.getId()).collectList()
											  .flatMap( current -> service.findSavingAccountByIdCustomer(cus.getId()).collectList()
											  .flatMap( saving -> service.findFixedTermByIdCustomer(cus.getId()).collectList()
											  .map(fixed -> new ReportGeneral(cus, credit, current, saving, fixed))))));
						
		return report;
//		RXJS
//		Flux<CreditCard> creditCard = service.findCreditCardByIdCustomer(id);
//		
//		Flux<CurrentAccount> currentAccounts = service.findCurrentAccountByIdCustomer(id);
//		
//		Flux<SavingAccount> savingAccounts = service.findSavingAccountByIdCustomer(id);
//		
//		Flux<FixedTerm> fixedAccounts = service.findFixedTermByIdCustomer(id);
//		
//		Mono<ReportGeneral> reportGeneral = Mono.just( new ReportGeneral(customer, creditCard, currentAccounts, savingAccounts, fixedAccounts));
//		
//		return reportGeneral;

	}

}
