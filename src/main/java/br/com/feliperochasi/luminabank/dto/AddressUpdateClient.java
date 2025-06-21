package br.com.feliperochasi.luminabank.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressUpdateClient(
        @NotNull
        @JsonAlias("address_id")
        Long addressId,
        String address,
        String neighborhood,
        @Pattern(regexp = "^\\d{5}-\\d{3}$")
        String zipCode,
        String complement,
        String number,
        String uf,
        String city
) {
}
