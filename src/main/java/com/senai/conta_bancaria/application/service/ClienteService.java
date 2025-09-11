package com.senai.conta_bancaria.application.service;

import com.senai.conta_bancaria.domain.entity.Cliente;
import com.senai.conta_bancaria.domain.repository.ClienteRepository;
import com.senai.conta_bancaria.domain.repository.ContaCorrenteRepository;
import com.senai.conta_bancaria.domain.repository.ContaPoupancaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    ContaPoupancaRepository contaPoupancaRepository;
}
