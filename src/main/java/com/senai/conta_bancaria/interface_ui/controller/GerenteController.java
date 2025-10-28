package com.senai.conta_bancaria.interface_ui.controller;

import com.senai.conta_bancaria.application.dto.*;
import com.senai.conta_bancaria.application.GerenteService.GerenteGerenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/gerente")
@RequiredArgsConstructor
public class GerenteController {

    private final GerenteService GerenteService;

    @PreAuthorize( "hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity <GerenteResponseDTO> registrarGerente(@Valid @RequestBody GerenteRegistroDTO dto){
        GerenteResponseDTO gerenteNovo = GerenteService.registrarGerente(dto);

        return ResponseEntity.created(URI.create("/api/gerente/cpf"+ gerenteNovo.cpf()))
                .body(gerenteNovo);
    }
    
    @PreAuthorize( "hasRole('ADMIN')")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<GerenteResponseDTO> bucarGerenteAtivoPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(GerenteService.bucarGerenteAtivoPorCpf(cpf));
    }
    
    @PreAuthorize( "hasRole('ADMIN')")
    @PutMapping("/cpf/{cpf}")
    public ResponseEntity <GerenteResponseDTO> atualizarGerente(@PathVariable String cpf,
                                                                @Valid @RequestBody GerenteAtualizadoDTO dto){
        return ResponseEntity.ok(GerenteService.atualizarGerente(cpf,dto));
    }
    
    @PreAuthorize( "hasRole('ADMIN')")
    @DeleteMapping("/{cpf}")
    public ResponseEntity <Void> deletarGerente(@PathVariable String cpf){
        GerenteService.deletarGerente(cpf);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<GerenteResponseDTO>> listarClientesAtivos(){
        return ResponseEntity.ok(GerenteService.listarGerentesAtivos());
    }
}
