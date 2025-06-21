package br.com.feliperochasi.luminabank.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressRegisterDTO(
        @NotNull
        @JsonAlias("client_id")
        Long clientId,
        @NotBlank
        String address,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "^\\d{5}-\\d{3}$")
        @JsonAlias("zip_code")
        String zipCode,
        String complement,
        String number,
        @NotBlank
        String uf,
        @NotBlank
        String city
) {
}
