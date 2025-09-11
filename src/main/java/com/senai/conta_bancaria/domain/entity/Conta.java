package com.senai.conta_bancaria.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Long nroConta;
    private Long saldo;
}
