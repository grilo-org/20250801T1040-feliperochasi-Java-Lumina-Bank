package br.com.feliperochasi.luminabank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    private Integer digit;

    private TypeAccount type;

    private PlanAccount plan;

    private int approved;

    private int active;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;
}
