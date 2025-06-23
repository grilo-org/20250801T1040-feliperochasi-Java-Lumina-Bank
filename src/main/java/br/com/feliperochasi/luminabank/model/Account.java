package br.com.feliperochasi.luminabank.model;

import br.com.feliperochasi.luminabank.dto.BankMovementDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    private Integer digit;

    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @Enumerated(EnumType.STRING)
    private PlanAccount plan;

    private int approved;

    private int active;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime deleted_at;

    private Float balance;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    public Account(Client clientForRegisterNewAccount, TypeAccount typeAccount, Long newAccountNumber, Integer newAccountDigit) {
        this.client = clientForRegisterNewAccount;
        this.type = typeAccount;
        this.number = newAccountNumber;
        this.digit = newAccountDigit;
        this.plan = PlanAccount.BASIC;
        this.approved = 0;
        this.active = 1;
        this.balance = 0.0F;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public void approveAccount() {
        this.approved = 1;
        this.updated_at = LocalDateTime.now();
    }

    public void inativeAccount() {
        this.active = 0;
        this.approved = 0;
        this.deleted_at = LocalDateTime.now();
    }

    public void pay(BankMovementDTO dto) {
        checkHaveIsBalanceToOperation(dto.amount());
        this.balance -= dto.amount();
    }

    public void deposit(BankMovementDTO dto) {
        this.balance += dto.amount();
    }

    public void transfer(BankMovementDTO dto) {
        checkHaveIsBalanceToOperation(dto.amount());
        this.balance -= dto.amount();
    }

    public void withdrawal(BankMovementDTO dto) {
        checkHaveIsBalanceToOperation(dto.amount());
        this.balance -= dto.amount();
    }

    private void checkHaveIsBalanceToOperation(Float amountOperation) {
        if (this.balance < amountOperation) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }
}
