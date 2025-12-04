package com.senai.conta_bancaria.interface_ui.controller;

import com.senai.conta_bancaria.application.dto.ClienteResponseDTO;
import com.senai.conta_bancaria.application.dto.PagamentoRegistroDTO;
import com.senai.conta_bancaria.application.dto.PagamentoResponseDTO;
import com.senai.conta_bancaria.application.service.PagamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
@RequiredArgsConstructor
public class PagamentoController {
    private final PagamentoService pagamentoService;

    // gets
    @GetMapping
    public ResponseEntity<List<PagamentoResponseDTO>> listarPagamentos(){
        return ResponseEntity.ok(pagamentoService.listarPagamentos());
    }

    @GetMapping("/boleto/{boleto}")
    public ResponseEntity<PagamentoResponseDTO> buscarPagamentoPorBoleto(@PathVariable String boleto){
        return ResponseEntity.ok(pagamentoService.buscarPagamentoPorBoleto(boleto));
    }

    // terminar
    @PostMapping
    public ResponseEntity<PagamentoResponseDTO> efetuarPagamento(@Valid @RequestBody PagamentoRegistroDTO dto) {
        return null;
    }
}
