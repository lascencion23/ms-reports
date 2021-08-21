package com.everis.msreports.entity;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SavingAccount {
	
    private String id;

    private String accountNumber;

    private List<Person> holders;

    private List<Person> signers;

    private Integer limitTransactions;

    private Integer freeTransactions;

    private Double commissionTransactions;

    private Double balance;

    private Double minAverageVip;

    private LocalDateTime date;



}
