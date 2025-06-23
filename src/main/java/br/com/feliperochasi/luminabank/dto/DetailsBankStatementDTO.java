package br.com.feliperochasi.luminabank.dto;

import br.com.feliperochasi.luminabank.model.BankStatement;
import br.com.feliperochasi.luminabank.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public record DetailsBankStatementDTO(
        @JsonAlias("transaction_type")
        TransactionType transactionType,
        Float amount,
        String description,
        String reference,
        @JsonAlias("transaction_date")
        LocalDateTime transactionDate
) {
    public DetailsBankStatementDTO(BankStatement bankStatement) {
        this(bankStatement.getTransaction_type(), bankStatement.getAmount(), bankStatement.getDescription(), bankStatement.getReference(), bankStatement.getTransaction_date());
    }
}
