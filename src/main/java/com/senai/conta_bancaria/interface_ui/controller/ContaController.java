package com.senai.conta_bancaria.interface_ui.controller;

import com.senai.conta_bancaria.application.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    ContaService contaService;

}
