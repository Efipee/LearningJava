package br.com.efipee.Aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

    // Tratamento da Exceção

    @ExceptionHandler({RecursoNaoEncontradoException.class})
    public ResponseEntity<String> handle(final RecursoNaoEncontradoException e) {
        final String recursoInexistente = "Não encontrado!";
        LOGGER.error(recursoInexistente);
        return new ResponseEntity<>(recursoInexistente, HttpStatus.NOT_FOUND);
    }
    
    
}
