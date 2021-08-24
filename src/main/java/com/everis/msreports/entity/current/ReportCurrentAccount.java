package com.everis.msreports.entity.current;

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
public class ReportCurrentAccount {
	
	private ConsultationPerProduct queryData;
	
	private List<CurrentList> resultados;

}
