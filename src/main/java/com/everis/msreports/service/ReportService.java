package com.everis.msreports.service;

import com.everis.msreports.entity.CreditCard;
import com.everis.msreports.entity.CurrentAccount;
import com.everis.msreports.entity.Customer;
import com.everis.msreports.entity.FixedTerm;
import com.everis.msreports.entity.SavingAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReportService {

	public Mono<Customer> findCustomerByIdCustomer(String id);
	
	public Flux<CreditCard> findCreditCardByIdCustomer(String id);
	public Flux<CurrentAccount> findCurrentAccountByIdCustomer(String id);
	public Flux<SavingAccount> findSavingAccountByIdCustomer(String id);
	public Flux<FixedTerm> findFixedTermByIdCustomer(String id);
}
