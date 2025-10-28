package com.senai.conta_bancaria.interface_ui.controller;

import com.senai.conta_bancaria.application.dto.ContaAtualizacaoDTO;
import com.senai.conta_bancaria.application.dto.ContaResumoDTO;
import com.senai.conta_bancaria.application.dto.TransferenciaDTO;
import com.senai.conta_bancaria.application.dto.ValorSaqueDepositoDTO;
import com.senai.conta_bancaria.application.service.ContaService;
import com.senai.conta_bancaria.domain.entity.Conta;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conta")
@RequiredArgsConstructor
public class ContaController {
    private final ContaService service;

    @PreAuthorize( "hasRole('GERENTE')")
    @GetMapping
    public ResponseEntity<List<ContaResumoDTO>> listarTodasContas() {
        return ResponseEntity.ok(service.listarTodasContas());
    }

    @PreAuthorize( "hasRole('GERENTE')")
    @GetMapping("/{numeroConta}")
    public ResponseEntity<ContaResumoDTO> buscarContaPorNumero(@PathVariable String numeroConta) {
        return ResponseEntity.ok(service.buscarContaPorNumero(numeroConta));
    }

    @PreAuthorize( "hasRole('GERENTE')")
    @PutMapping("/{numeroConta}")
    public ResponseEntity<ContaResumoDTO> atualizarConta(@PathVariable String numeroConta,
                                                         @Valid @RequestBody ContaAtualizacaoDTO dto) {
        return ResponseEntity.ok(service.atualizarConta(numeroConta, dto));
    }

    @PreAuthorize( "hasRole('GERENTE')")
    @DeleteMapping("/{numeroConta}")
    public ResponseEntity<Void> deletarConta(@PathVariable String numeroConta) {
        service.deletarConta(numeroConta);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize( "hasRole('CLIENTE')")
    @PostMapping("/{numeroConta}/sacar")
    public ResponseEntity<ContaResumoDTO> sacar(@PathVariable String numeroConta,
                                                @Valid @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.sacar(numeroConta, dto));
    }

    @PreAuthorize( "hasRole('CLIENTE')")
    @PostMapping("/{numeroConta}/depositar")
    public ResponseEntity<ContaResumoDTO> depositar(@PathVariable String numeroConta,
                                                    @Valid @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.depositar(numeroConta, dto));
    }

    @PreAuthorize( "hasRole('CLIENTE')")
    @PostMapping("/{numeroConta}/transferir")
    public ResponseEntity<ContaResumoDTO> transferir(@PathVariable String numeroConta,
                                                @Valid @RequestBody TransferenciaDTO dto) {
        return ResponseEntity.ok(service.transferir(numeroConta, dto));
    }

    @PreAuthorize( "hasRole('GERENTE')")
    @PostMapping("/{numeroConta}/rendimento")
    public ResponseEntity<ContaResumoDTO> aplicarRendimento(@PathVariable String numeroConta) {
        return ResponseEntity.ok(service.aplicarRendimento(numeroConta));
    }
}


