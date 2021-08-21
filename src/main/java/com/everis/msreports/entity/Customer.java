package com.everis.msreports.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Data
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

