package br.com.feliperochasi.luminabank.model;


import br.com.feliperochasi.luminabank.dto.AddressRegisterDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String address;

    private String neighborhood;

    private String zipcode;

    private String complement;

    private String number;

    private String uf;

    private String city;

    @ManyToOne
    private Client client;

    public Address(AddressRegisterDTO dto, Client clientForAddress) {
        this.address = dto.address();
        this.neighborhood = dto.neighborhood();
        this.zipcode = dto.zipCode();
        this.complement = dto.complement().isEmpty() ? "" : dto.complement();
        this.number = dto.number().isEmpty() ? "" : dto.number();
        this.uf = dto.uf();
        this.city = dto.city();
        this.client = clientForAddress;
    }
}
