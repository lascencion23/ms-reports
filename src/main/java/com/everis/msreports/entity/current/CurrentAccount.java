package com.everis.msreports.entity.current;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

import com.everis.msreports.entity.customer.Person;

@Data
public class CurrentAccount {
	
    private String id;
    
    private String accountNumber;

    private List<Person> holders;

    private List<Person> signers;

    private Integer freeTransactions;

    private Double commissionTransactions;

    private Double commissionMaintenance;

    private Double balance;

    private LocalDateTime date;
}
