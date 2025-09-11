package com.senai.conta_bancaria.application.service;

import com.senai.conta_bancaria.domain.repository.ContaCorrenteRepository;
import com.senai.conta_bancaria.domain.repository.ContaPoupancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContaService {
    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    ContaPoupancaRepository contaPoupancaRepository;

}
