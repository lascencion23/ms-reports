package com.everis.msreports.entity.fixedTerm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.everis.msreports.entity.TypeTransaction;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFixedTerm {
	
    private String id;

    private FixedTerm fixedTerm;

    private String transactionCode;

    private TypeTransaction typeTransaction;

    private Double transactionAmount;

    private Double commissionAmount;

    private LocalDateTime transactionDateTime;

}
