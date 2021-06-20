package br.com.efipee.filmes.processors;


import org.springframework.stereotype.Component;

import br.com.efipee.filmes.entities.Filme;

@Component
public interface Processor {

    public void process(Filme filmes);
    
}
