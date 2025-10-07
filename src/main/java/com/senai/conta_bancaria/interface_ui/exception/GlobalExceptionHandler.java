package com.senai.conta_bancaria.interface_ui.exception;

import com.senai.conta_bancaria.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValoresNegativosException.class)
    public ResponseEntity<String> handleValoresNegativos(ValoresNegativosException ex) {
        return new ResponseEntity <>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransferirParaMesmaContaException.class)
    public ResponseEntity<String> handleTransferirParaMesmaConta(TransferirParaMesmaContaException ex) {
        return new ResponseEntity <>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TipoDeContaInvalidaException.class)
    public ResponseEntity<String> handleTipoDeContaInvalidaException(TipoDeContaInvalidaException ex) {
        return new ResponseEntity <>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<String> handleSaldoInsuficienteException(SaldoInsuficienteException ex) {
        return new ResponseEntity <>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(RendimentoInvalidoException.class)
    public ResponseEntity<String> handleRendimentoInvalidoException(RendimentoInvalidoException ex) {
        return new ResponseEntity <>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<String> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex) {
        return new ResponseEntity <>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ContaDoMesmoTipoException.class)
    public ResponseEntity<String> handleContaDoMesmoTipoException(ContaDoMesmoTipoException ex) {
        return new ResponseEntity <>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
