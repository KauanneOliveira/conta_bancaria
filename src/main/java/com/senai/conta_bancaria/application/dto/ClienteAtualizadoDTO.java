package com.senai.conta_bancaria.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record ClienteAtualizadoDTO(
        @NotBlank(message = "O nome não pode ser vazio")
        @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome deve conter apenas letras")
        String nome,

        @NotBlank(message = "O CPF não pode ser vazio")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos")
        String cpf
) {

}
