package br.com.feliperochasi.luminabank.dto;

import br.com.feliperochasi.luminabank.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BankMovementDTO(
        @NotNull
        @JsonAlias("origin_account")
        Long originAccount,
        @NotNull
        @JsonAlias("transaction_type")
        TransactionType transactionType,
        @NotBlank
        String description,
        @NotBlank
        String reference,
        @NotNull
        Float amount,
        @JsonAlias("reciver_number")
        Long reciverNumber
) {
}
