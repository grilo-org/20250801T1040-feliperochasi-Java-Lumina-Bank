package br.com.feliperochasi.luminabank.dto;

import br.com.feliperochasi.luminabank.model.Address;

public record DetailsAddressDTO(
        String address,
        String neighborhood,
        String zipcode,
        String complement,
        String number,
        String uf,
        String city
) {
    public DetailsAddressDTO(Address address) {
        this(address.getAddress(), address.getNeighborhood(), address.getZipcode(), address.getComplement(), address.getNumber(), address.getUf(), address.getCity());
    }
}
