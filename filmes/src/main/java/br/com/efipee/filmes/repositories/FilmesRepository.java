package br.com.efipee.filmes.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.efipee.filmes.entities.Filme;

public class FilmesRepository {

    private final List<Filme> filmes;

    private static FilmesRepository filmesRepository;

    public FilmesRepository() {
        this.filmes = new ArrayList<>();
    }

    

    public static FilmesRepository getInstance() {
        if (filmesRepository == null) {
            filmesRepository = new FilmesRepository();
        }
        return filmesRepository;
    }

    public List<Filme> listarFilmes() {
        return filmes;
    }

    public List<Filme> listarFilmes(final String movie) {
        return filmes.stream().filter(film -> film.getNomeFilme().contains(movie)).collect(Collectors.toList());
    }

    public Filme acharPeloId(Integer id) {
        return this.filmes.stream().filter(film -> film.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(final Filme movie) {
        filmes.stream().filter(film -> film.getId().equals(film.getId()))
                .forEach(film -> film.setNomeFilme(film.getNomeFilme()));
    }

    public void delete(Integer id) {
        filmes.removeIf(film -> film.getId().equals(id));
    }

    public void add(Filme movie) {
        if(this.filmes.contains(movie)){
            System.out.println("Já existe no catálogo");
        }
            System.out.println("Filme adicionado");
        this.filmes.add(movie);
    }

    public int count() {
        return filmes.size();
    }

}
