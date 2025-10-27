package com.senai.conta_bancaria.application.service;

import com.senai.conta_bancaria.application.dto.GerenteDTO;
import com.senai.conta_bancaria.domain.entity.Gerente;
import com.senai.conta_bancaria.domain.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GerenteService {

    private final GerenteRepository gerenteRepository;
    private final PasswordEncoder encoder;

    public List<GerenteDTO> listarTodosGerentes() {
        return GerenteRepository.findAll().stream()
                .map(GerenteDTO::fromEntity)
                .toList();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public GerenteDTO cadastrarGerente(GerenteDTO dto) {
        Gerente entity = dto.toEntity();
        entity.setSenha(encoder.encode(dto.senha()));
        entity.setRole(Role.GERENTE);
        gerenteRepository.save(entity);
        return GerenteDTO.fromEntity(entity);
    }
}
