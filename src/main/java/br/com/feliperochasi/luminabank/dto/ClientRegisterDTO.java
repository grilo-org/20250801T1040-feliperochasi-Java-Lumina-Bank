package br.com.feliperochasi.luminabank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ClientRegisterDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^\\d{11}$")
        String cpf,
        @NotBlank
        String phone,
        @NotNull
        LocalDate birthday
) {
}
