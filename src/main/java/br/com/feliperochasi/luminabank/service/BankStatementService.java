package br.com.feliperochasi.luminabank.service;

import br.com.feliperochasi.luminabank.dto.BankMovementDTO;
import br.com.feliperochasi.luminabank.model.Account;
import br.com.feliperochasi.luminabank.model.BankStatement;
import br.com.feliperochasi.luminabank.model.TransactionType;
import br.com.feliperochasi.luminabank.repository.AccountRepository;
import br.com.feliperochasi.luminabank.repository.BankStatementRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankStatementService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BankStatementRepository bankStatementRepository;

    public void applyNewBankingMovement(@Valid BankMovementDTO dto) {
        Account accountClientOperator = findAccountByNumber(dto.originAccount());
        switch (dto.transactionType()) {
            case PAY -> accountClientOperator.pay(dto);
            case DEPOSIT -> accountClientOperator.deposit(dto);
            case TRANSFER -> accountClientOperator.transfer(dto);
            case WITHDRAWAL -> accountClientOperator.withdrawal(dto);
            default -> throw new RuntimeException("Operacao invalida");
        }
        var amountToOperator = dto.transactionType() ==  TransactionType.DEPOSIT ? dto.amount() : dto.amount() * -1;
        BankStatement newOperation = new BankStatement(accountClientOperator, dto, amountToOperator);
        bankStatementRepository.save(newOperation);
    }

    private Account findAccountByNumber(Long number) {
        return accountRepository.findByNumberEquals(number);
    }
}
