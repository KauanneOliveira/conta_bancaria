package com.senai.conta_bancaria.interface_ui.controller;

import com.senai.conta_bancaria.application.dto.ContaAtualizacaoDTO;
import com.senai.conta_bancaria.application.dto.ContaResumoDTO;
import com.senai.conta_bancaria.application.dto.TransferenciaDTO;
import com.senai.conta_bancaria.application.dto.ValorSaqueDepositoDTO;
import com.senai.conta_bancaria.application.service.ContaService;
import com.senai.conta_bancaria.domain.entity.Conta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conta")
@RequiredArgsConstructor
public class ContaController {
    private final ContaService service;

    @GetMapping
    public ResponseEntity<List<ContaResumoDTO>> listarTodasContas() {
        return ResponseEntity.ok(service.listarTodasContas());
    }

    @GetMapping("/{numeroConta}")
    public ResponseEntity<ContaResumoDTO> buscarContaPorNumero(@PathVariable String numeroConta) {
        return ResponseEntity.ok(service.buscarContaPorNumero(numeroConta));
    }

    @PutMapping("/{numeroConta}")
    public ResponseEntity<ContaResumoDTO> atualizarConta(@PathVariable String numeroConta,
                                                         @RequestBody ContaAtualizacaoDTO dto) {
        return ResponseEntity.ok(service.atualizarConta(numeroConta, dto));
    }

    @DeleteMapping("/{numeroConta}")
    public ResponseEntity<Void> deletarConta(@PathVariable String numeroConta) {
        service.deletarConta(numeroConta);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{numeroConta}/sacar")
    public ResponseEntity<ContaResumoDTO> sacar(@PathVariable String numeroConta,
                                                @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.sacar(numeroConta, dto));
    }

    @PostMapping("/{numeroConta}/depositar")
    public ResponseEntity<ContaResumoDTO> depositar(@PathVariable String numeroConta,
                                                @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.depositar(numeroConta, dto));
    }

    @PostMapping("/{numeroConta}/transferir")
    public ResponseEntity<ContaResumoDTO> transferir(@PathVariable String numeroConta,
                                                @RequestBody TransferenciaDTO dto) {
        return ResponseEntity.ok(service.transferir(numeroConta, dto));
    }

    @PostMapping("/{numeroConta}/rendimento")
    public ResponseEntity<ContaResumoDTO> aplicarRendimento(@PathVariable String numeroConta) {
        return ResponseEntity.ok(service.aplicarRendimento(numeroConta));
    }
}


