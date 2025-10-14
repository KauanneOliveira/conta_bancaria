package com.senai.conta_bancaria.application.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ContaAtualizacaoDTO(
        @NotNull(message = "O campo 'saldo' é obrigatório.")
        BigDecimal saldo,

        @NotNull(message = "O campo 'limite' é obrigatório.")
        BigDecimal limite,

        @NotNull(message = "O campo 'rendimento' é obrigatório.")
        BigDecimal rendimento,

        @NotNull(message = "O campo 'taxa' é obrigatório.")
        BigDecimal taxa
) {
}
