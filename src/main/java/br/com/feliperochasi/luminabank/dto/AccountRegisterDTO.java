package br.com.feliperochasi.luminabank.dto;

import br.com.feliperochasi.luminabank.model.TypeAccount;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record AccountRegisterDTO(
        @NotNull
        @JsonAlias("client_id")
        Long clientId,
        @NotNull
        @JsonAlias("type_account")
        TypeAccount typeAccount
        ) {
}
