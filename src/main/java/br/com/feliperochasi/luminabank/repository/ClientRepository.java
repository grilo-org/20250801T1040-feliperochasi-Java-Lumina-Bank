package br.com.feliperochasi.luminabank.repository;

import br.com.feliperochasi.luminabank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByActiveEquals(Long active);
}
