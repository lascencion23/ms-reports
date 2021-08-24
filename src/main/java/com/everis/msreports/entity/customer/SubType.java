package com.everis.msreports.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubType {
    String id;

    EnumSubType value;

    public enum EnumSubType{
        NORMAL, VIP, PYME
    }
}
