package com.senai.conta_bancaria.interface_ui.controller;

import com.senai.conta_bancaria.application.dto.CodigoRegistroDTO;
import com.senai.conta_bancaria.application.dto.CodigoResponseDTO;
import com.senai.conta_bancaria.application.service.CodigoAutenticacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autenticacao")
@RequiredArgsConstructor
public class CodigoAutenticacaoController {
    private final CodigoAutenticacaoService codigoAutenticacaoService;

    @PostMapping("/registrar")
    public ResponseEntity<CodigoResponseDTO> registrarCodigo(@Valid @RequestBody CodigoRegistroDTO dto) {
        return ResponseEntity.ok(codigoAutenticacaoService.registrarCodigo(dto));
    }

    // post de validar
}
