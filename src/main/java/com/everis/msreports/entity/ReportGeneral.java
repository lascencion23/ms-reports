package com.everis.msreports.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportGeneral {
	
	private Customer customer;
	
	private List<CreditCard> creditCards;
	
	private List<CurrentAccount> currentsAccounts;
	
	private List<SavingAccount> savingAccounts;
	
	private List<FixedTerm> fixedTermAccounts;
	
}
