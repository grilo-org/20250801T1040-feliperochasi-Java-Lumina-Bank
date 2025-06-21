package br.com.feliperochasi.luminabank.dto;

import br.com.feliperochasi.luminabank.model.Client;

import java.util.List;

public record DetailsClientDTO(
        String name,
        String email,
        String cpf,
        String phone,
        List<DetailsAddressDTO> addresses
) {
    public DetailsClientDTO(Client client) {
        this(client.getName(), client.getEmail(), client.getCpf(), client.getPhone(), client.getAddress().stream().map(DetailsAddressDTO::new).toList());
    }
}
