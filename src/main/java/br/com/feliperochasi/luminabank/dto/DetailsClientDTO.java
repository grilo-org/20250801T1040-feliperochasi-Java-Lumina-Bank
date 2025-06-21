package br.com.feliperochasi.luminabank.dto;

import br.com.feliperochasi.luminabank.model.Client;

public record DetailsClientDTO(
        String name,
        String email,
        String cpf,
        String phone
) {
    public DetailsClientDTO(Client client) {
        this(client.getName(), client.getEmail(), client.getCpf(), client.getPhone());
    }
}
