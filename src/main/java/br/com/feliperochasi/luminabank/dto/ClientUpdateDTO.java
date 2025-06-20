package br.com.feliperochasi.luminabank.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ClientUpdateDTO(
        @NotNull
        @JsonAlias("client_id")
        Long clientId,
        String name,
        @Email
        String email,
        String phone
) {
}
