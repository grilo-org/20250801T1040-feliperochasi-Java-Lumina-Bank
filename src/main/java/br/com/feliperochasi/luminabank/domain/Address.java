package br.com.feliperochasi.luminabank.domain;


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
    private User user;
}
