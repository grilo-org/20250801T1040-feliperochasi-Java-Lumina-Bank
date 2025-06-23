package br.com.feliperochasi.luminabank.repository;

import br.com.feliperochasi.luminabank.model.Account;
import br.com.feliperochasi.luminabank.model.BankStatement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankStatementRepository extends JpaRepository<BankStatement, Long> {
    List<BankStatement> findByAccountEquals(Account accountToListBankStatement);
}
