package com.everis.msreports.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.everis.msreports.entity.credit.Credit;
import com.everis.msreports.entity.credit.CreditCard;
import com.everis.msreports.entity.credit.CreditTransaction;
import com.everis.msreports.entity.current.CurrentAccount;
import com.everis.msreports.entity.current.TransactionCurrentAccount;
import com.everis.msreports.entity.customer.Customer;
import com.everis.msreports.entity.fixedTerm.FixedTerm;
import com.everis.msreports.entity.fixedTerm.TransactionFixedTerm;
import com.everis.msreports.entity.saving.SavingAccount;
import com.everis.msreports.entity.saving.SavingAccountTransaction;
import com.everis.msreports.service.ReportService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReportServiceImpl implements ReportService {

	private final WebClient webClient;

	String uri = "http://localhost:8090/api";

	public ReportServiceImpl() {
		this.webClient = WebClient.builder().baseUrl(this.uri).build();
	}

	// ******** CUSTOMER ********
	@Override
	public Mono<Customer> findCustomerByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-customer/customer/find/{id}", id).accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(Customer.class);
	}
	
	
	// ******** CREDIT CARD ********
	@Override
	public Flux<CreditCard> findCreditCards() {
		return webClient.get().uri(this.uri + "/ms-creditcard/creditcard/list")
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CreditCard.class);
	}
	
	@Override
	public Flux<Credit> findCreditByIdCreditCard(String id) {
		return webClient.get().uri(this.uri + "/ms-credit-charge/creditCharge/findByIdCreditCard/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(Credit.class);
	};
	
	@Override
	public Flux<CreditTransaction> FindCreditPayByIdCreditCard(String id) {
		return webClient.get().uri(this.uri + "/ms-credit-pay/creditPaid/findByIdCreditCard/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CreditTransaction.class);
	}

	@Override
	public Flux<CreditCard> findCreditCardByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-creditcard/creditcard/findCreditCards/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CreditCard.class);
	}
	
	
	// ******** FIXED ACCOUNT ********
	
	@Override
	public Flux<FixedTerm> findFixeds() {
		return webClient.get().uri(this.uri + "/ms-fixed-term/fixedTerm/list")
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(FixedTerm.class);
	}

	@Override
	public Flux<TransactionFixedTerm> findTransactionFixedByIdFixed(String id) {
		return webClient.get().uri(this.uri + "/ms-fixed-term-transaction/transactionFixedTerm/findByFixedId/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(TransactionFixedTerm.class);
	}
	
	@Override
	public Flux<FixedTerm> findFixedTermByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-fixed-term/fixedTerm/findAccountByCustomerId/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(FixedTerm.class);
	}
	
	
	// ******** CURRENT ACCOUNT ********
	
	@Override
	public Flux<CurrentAccount> findCurrents() {
		return webClient.get().uri(this.uri + "/ms-current-account/currentAccount/list")
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CurrentAccount.class);
	}

	@Override
	public Flux<TransactionCurrentAccount> findTransactionCurrentByIdCurrent(String id) {
		return webClient.get().uri(this.uri + "/ms-current-account-transaction/transactionCurrentAccount/findByCurrentAccountId/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(TransactionCurrentAccount.class);
	}
	
	
	@Override
	public Flux<CurrentAccount> findCurrentAccountByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-current-account/currentAccount/findAccountByCustomerId/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CurrentAccount.class);
	}	
	
	
	// ******** SAVING ACCOUNT ********

	@Override
	public Flux<SavingAccount> findSavings() {
		return webClient.get().uri(this.uri + "/ms-saving-account/savingAccount/list")
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(SavingAccount.class);
	}

	@Override
	public Flux<SavingAccountTransaction> findTransactionSavingsByIdSaving(String id) {
		return webClient.get().uri(this.uri + "/ms-saving-account-transaction/transactionSavingAccount/findBySavingAccountId/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(SavingAccountTransaction.class);
	}
	
	@Override
	public Flux<SavingAccount> findSavingAccountByIdCustomer(String id) {
		return webClient.get().uri(this.uri + "/ms-saving-account/savingAccount/findAccountByCustomerId/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(SavingAccount.class);
	}
	
	
	// ******** TOOLS ********
	@Override
	public boolean isWithInRange(LocalDateTime createAt, LocalDate start, LocalDate end) {
		return createAt.toLocalDate().isAfter(start) && createAt.toLocalDate().isBefore(end);
	}

}
