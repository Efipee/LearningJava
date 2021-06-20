package br.com.efipee.filmes.processors;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.efipee.filmes.entities.Filme;


@Component
public class Verificador implements Processor {

    private final List<Filme> filmes;

    public Verificador(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public void process(Filme movie) {
        if(filmes.contains(movie)){
            System.out.println("Filme já existe no catálogo!");;
        }        
        System.out.println("Deu tudo certo!");
        
    }
    
}
