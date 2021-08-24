package com.everis.msreports.entity.current;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentList {

	private CurrentAccount current;
	
	private List<TransactionCurrentAccount> transactions;

}
