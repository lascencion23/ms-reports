package com.everis.msreports.entity.saving;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

import com.everis.msreports.entity.customer.Person;

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
