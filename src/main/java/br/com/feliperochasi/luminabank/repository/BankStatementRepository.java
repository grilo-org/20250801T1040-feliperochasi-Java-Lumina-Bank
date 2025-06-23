package br.com.feliperochasi.luminabank.repository;

import br.com.feliperochasi.luminabank.model.BankStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankStatementRepository extends JpaRepository<BankStatement, Long> {
}
