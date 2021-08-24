package com.everis.msreports.entity.saving;

import java.util.List;

import com.everis.msreports.entity.ConsultationPerProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ReportSavingAccount {
	
	private ConsultationPerProduct queryData;
	
	private List<SavingList> resultados;

}
