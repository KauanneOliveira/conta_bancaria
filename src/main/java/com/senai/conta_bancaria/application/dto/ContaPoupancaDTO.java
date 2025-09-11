package com.senai.conta_bancaria.application.dto;

import com.senai.conta_bancaria.domain.entity.ContaPoupanca;

public record ContaPoupancaDTO(
        String id,
        Long nroConta,
        Long saldo,
        Integer rendimento
) {
    public static ContaPoupancaDTO fromEntity(ContaPoupanca contaPoupanca) {
        if (contaPoupanca == null)
            return null;

        return new ContaPoupancaDTO(
                contaPoupanca.getId(),
                contaPoupanca.getNroConta(),
                contaPoupanca.getSaldo(),
                contaPoupanca.getRendimento()
        );
    }

    public ContaPoupanca toEntity() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setNroConta(this.nroConta);
        contaPoupanca.setSaldo(this.saldo);
        contaPoupanca.setRendimento(this.rendimento);

        return contaPoupanca;
    }
}
