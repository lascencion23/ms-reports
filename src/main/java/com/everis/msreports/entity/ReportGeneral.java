package com.everis.msreports.entity;

import java.util.List;

import com.everis.msreports.entity.credit.CreditCard;
import com.everis.msreports.entity.current.CurrentAccount;
import com.everis.msreports.entity.customer.Customer;
import com.everis.msreports.entity.fixedTerm.FixedTerm;
import com.everis.msreports.entity.saving.SavingAccount;

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
