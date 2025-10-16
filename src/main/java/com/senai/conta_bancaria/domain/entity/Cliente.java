package com.senai.conta_bancaria.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "cliente",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "cpf")
        })
public class Cliente extends Usuario{

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="cliente_contas", joinColumns=@JoinColumn(name="cliente_id"))
    @Column(name="conta")
    private List<Conta> contas;

}
