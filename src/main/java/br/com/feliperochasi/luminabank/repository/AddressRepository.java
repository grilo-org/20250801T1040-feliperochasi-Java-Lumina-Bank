package br.com.feliperochasi.luminabank.repository;

import br.com.feliperochasi.luminabank.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
