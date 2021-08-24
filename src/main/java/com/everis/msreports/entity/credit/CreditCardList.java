package com.everis.msreports.entity.credit;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardList {

	private CreditCard creditCard;
	
	private List<Credit> credits;
	
	private List<CreditTransaction> creditsPays;
	
}
