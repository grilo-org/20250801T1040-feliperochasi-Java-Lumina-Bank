package br.com.feliperochasi.luminabank.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String address;

    private String neighborhood;

    private String zipcode;

    private String complement;

    private String number;

    private String uf;

    private String city;

    @ManyToOne
    private User user;
}
