package br.com.feliperochasi.luminabank.repository;

import br.com.feliperochasi.luminabank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
