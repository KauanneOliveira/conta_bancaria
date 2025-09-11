package com.senai.conta_bancaria.application.dto;

import com.senai.conta_bancaria.domain.entity.Cliente;
import com.senai.conta_bancaria.domain.entity.Conta;
import com.senai.conta_bancaria.domain.entity.ContaCorrente;

public record ContaCorrenteDTO(
        String id,
        Long nroConta,
        Long saldo,
        Long limite,
        Integer taxa
) {
    public static ContaCorrenteDTO fromEntity(ContaCorrente contaCorrente){
        if (contaCorrente == null)
            return null;

        return new ContaCorrenteDTO(
                contaCorrente.getId(),
                contaCorrente.getNroConta(),
                contaCorrente.getSaldo(),
                contaCorrente.getLimite(),
                contaCorrente.getTaxa()
        );
    }

    public ContaCorrente toEntity() {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setNroConta(this.nroConta);
        contaCorrente.setSaldo(this.saldo);
        contaCorrente.setLimite(this.limite);
        contaCorrente.setTaxa(this.taxa);
        return contaCorrente;
    }
}
