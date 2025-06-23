package br.com.feliperochasi.luminabank.repository;

import br.com.feliperochasi.luminabank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByNumberAndDigit(Long number, Integer digit);

    Account findByNumberEquals(Long number);
}
