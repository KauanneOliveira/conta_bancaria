package com.senai.conta_bancaria.application.dto;

import com.senai.conta_bancaria.domain.entity.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ClienteResponseDTO(
        @NotNull(message = "Id do cliente é obrigatório")
        String id,

        @NotBlank(message = "O nome não pode ser vazio")
        String nome,

        @NotBlank(message = "O CPF não pode ser vazio")
        String cpf,

        @NotNull(message = "A lista de contas não pode ser nula")
        List<ContaResumoDTO> contas
) {

    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        // tá pegando cada conta(normal) da lista e transformando em ContaResumoDTO
        List<ContaResumoDTO> contas = cliente.getContas()
                .stream()
                .map(ContaResumoDTO::fromEntity)
                .toList();

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                contas
        );
    }
}
