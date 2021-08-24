package com.everis.msreports.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReportService {

	// CUSTOMER
	public Mono<Customer> findCustomerByIdCustomer(String id);
	
	// CREDIT
	public Flux<CreditCard> findCreditCards();
	public Flux<Credit> findCreditByIdCreditCard(String id);
	public Flux<CreditTransaction> FindCreditPayByIdCreditCard(String id);
	public Flux<CreditCard> findCreditCardByIdCustomer(String id);
	
	// FIXED
	public Flux<FixedTerm> findFixeds();
	public Flux<TransactionFixedTerm> findTransactionFixedByIdFixed(String id);
	public Flux<FixedTerm> findFixedTermByIdCustomer(String id);
	
	// CURRENT
	public Flux<CurrentAccount> findCurrents();
	public Flux<TransactionCurrentAccount> findTransactionCurrentByIdCurrent(String id);
	public Flux<CurrentAccount> findCurrentAccountByIdCustomer(String id);
	
	// SAVING
	public Flux<SavingAccount> findSavings();
	public Flux<SavingAccountTransaction> findTransactionSavingsByIdSaving(String id);
	public Flux<SavingAccount> findSavingAccountByIdCustomer(String id);

	//TOOL
	boolean isWithInRange(LocalDateTime createAt, LocalDate start, LocalDate end);
	
}
