package com.everis.msreports.service.impl;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.everis.msreports.entity.CreditCard;
import com.everis.msreports.entity.CurrentAccount;
import com.everis.msreports.entity.Customer;
import com.everis.msreports.entity.FixedTerm;
import com.everis.msreports.entity.SavingAccount;
import com.everis.msreports.service.ReportService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReportServiceImpl implements ReportService {
	
	// @Autowired
	// private ReportsRepository repository;
	
	private final WebClient webClient;
	
	String uri = "http://localhost:8090/api";
	
	public ReportServiceImpl() {
		this.webClient = WebClient.builder().baseUrl(this.uri).build();
	}
	
	@Override
	public Mono<Customer> findCustomerByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-customer/customer/find/{id}",id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Customer.class);
	}

	@Override
	public Flux<CreditCard> findCreditCardByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-creditcard/creditcard/findCreditCards/{id}",id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CreditCard.class);
	}

	@Override
	public Flux<CurrentAccount> findCurrentAccountByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-current-account/currentAccount/findAccountByCustomerId/{id}",id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CurrentAccount.class);
	}

	@Override
	public Flux<SavingAccount> findSavingAccountByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-saving-account/savingAccount/findAccountByCustomerId/{id}",id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(SavingAccount.class);
	}

	@Override
	public Flux<FixedTerm> findFixedTermByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-fixed-term/fixedTerm/findAccountByCustomerId/{id}",id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(FixedTerm.class);
	}

}
