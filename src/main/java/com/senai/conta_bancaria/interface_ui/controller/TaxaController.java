package com.senai.conta_bancaria.interface_ui.controller;

import com.senai.conta_bancaria.application.dto.TaxaResponseDTO;
import com.senai.conta_bancaria.application.service.TaxaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxas")
@RequiredArgsConstructor
public class TaxaController {

    private final TaxaService service;

    @GetMapping
    public ResponseEntity<List<TaxaResponseDTO>> listarTaxas() {
        return ResponseEntity.ok(service.listarTaxas());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TaxaResponseDTO> buscarTaxa(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarTaxaPorId(id));
    }

    // registrar Taxa

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTaxa(@PathVariable String id) {
        service.deletarTaxa(id);
        return ResponseEntity.noContent().build();
    }
}
