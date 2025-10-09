package com.senai.conta_bancaria.application.dto;

import jakarta.validation.constraints.NotBlank;


public record ClienteAtualizadoDTO(
        @NotBlank(message = "O nome não pode ser vazio")
        String nome,

        @NotBlank(message = "O CPF não pode ser vazio")
        String cpf
) {

}
