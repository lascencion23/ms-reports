package com.everis.msreports.entity.saving;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import com.everis.msreports.entity.TypeTransaction;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavingAccountTransaction {
    @Id
    private String id;

    @NotNull
    private SavingAccount savingAccount;

    @NotBlank
    private String transactionCode;

    @NotNull
    private TypeTransaction typeTransaction;

    @NotNull
    private Double transactionAmount;

    private Double commissionAmount;

    private LocalDateTime transactionDateTime;


}
