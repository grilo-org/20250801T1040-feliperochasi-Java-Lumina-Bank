package br.com.feliperochasi.luminabank.model;

import jakarta.persistence.*;
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

    private Float balance;

    private String description;

    private String reference;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
