package com.senai.conta_bancaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_conta", discriminatorType = DiscriminatorType.STRING, length = 20)
@Table(name = "contaDTO",
        uniqueConstraints =  {
            @UniqueConstraint(name = "uk_conta_numero", columnNames = "numero"),
            @UniqueConstraint(name = "uk_cliente_tipo", columnNames = {"cliente_id", "tipo_conta"})
        })
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 20)
    private String numero;

    @Column(nullable = false, precision = 4)
    private BigDecimal saldo;

    @Column(nullable = false)
    private boolean ativa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id",
            foreignKey = @ForeignKey(name = "fk_conta_cliente"))
    private Cliente cliente;

    // Obriga quem herdar a implementar esse metodo e retornar uma string
    public abstract String getTipo();

    public void sacar(BigDecimal valor) {
        validarValorMaiorQueZero(valor);
        if(valor.compareTo(saldo) > 0) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        saldo = saldo.subtract(valor);
    }

    public void depositar(BigDecimal valor) {
        validarValorMaiorQueZero(valor);
        saldo = saldo.add(valor);
    }

    protected static void validarValorMaiorQueZero(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
    }

    public void transferir (BigDecimal valor, Conta contaDestino) {
        if(this.id.equals(contaDestino.getId())) {
            throw new IllegalArgumentException("não é possivel transferir para a mesma conta");
        }

        this.sacar(valor);
        contaDestino.depositar(valor);
    }
}
