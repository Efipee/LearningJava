package br.com.efipee.filmes.service;

import java.util.List;

import br.com.efipee.filmes.entities.Filme;

public interface IFilmesService {

    public List<Filme> listarFilmes(String movie);
    public Filme acharPeloId(Integer id);
    public Integer add(Filme filme);
    public void update(final Filme filme);
    public void delete(Integer id);

    
}
