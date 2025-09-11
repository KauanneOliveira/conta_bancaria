package com.senai.conta_bancaria.domain.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ContaCorrente extends Conta {
    private Long limite;
    private Integer taxa;
}
