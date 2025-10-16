package com.senai.conta_bancaria.domain.entity;

import com.senai.conta_bancaria.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name="gerentes")
public class Gerente extends Usuario{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Role role;
}
