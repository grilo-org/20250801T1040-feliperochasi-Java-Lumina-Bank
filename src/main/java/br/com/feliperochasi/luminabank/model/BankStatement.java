package br.com.feliperochasi.luminabank.model;

import br.com.feliperochasi.luminabank.dto.BankMovementDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bank_statement")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime transaction_date;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transaction_type;

    private Float amount;

    private String description;

    private String reference;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public BankStatement(Account accountClientOperator, TransactionType transactionType, String description, String reference, Float updatedAmount) {
        this.account = accountClientOperator;
        this.transaction_date = LocalDateTime.now();
        this.transaction_type = transactionType;
        this.amount = updatedAmount;
        this.description = description;
        this.reference = reference;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }
}
