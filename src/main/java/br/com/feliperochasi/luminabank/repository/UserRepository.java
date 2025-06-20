package br.com.feliperochasi.luminabank.repository;

import br.com.feliperochasi.luminabank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
