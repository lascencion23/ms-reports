package com.everis.msreports.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String id;

    private String name;

    private String lastName;

    private TypeCustomer typeCustomer;

    private DocumentType documentType;
    
    private String documentNumber;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    private String gender;

    public enum DocumentType {
    	DNI,
    	PASAPORTE
    }
    
}

