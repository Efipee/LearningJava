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
        filmes.stream().filter(film -> film.getId().equals(movie.getId()))
                .forEach(film -> film.setNomeFilme(movie.getNomeFilme()));
                //
        filmes.stream().filter(film -> film.getId().equals(movie.getId()))
                .forEach(film -> film.setAno(movie.getAno()));        
                //
        filmes.stream().filter(film -> film.getId().equals(movie.getId()))
                .forEach(film -> film.setDiretor(movie.getDiretor()));      
                //          
        filmes.stream().filter(film -> film.getId().equals(movie.getId()))
                .forEach(film -> film.setNota(movie.getNota()));                 
                
    }

    public void delete(Integer id) {
        this.filmes.removeIf(movie -> movie.getId().equals(id));
    }

    public boolean containsID(final Filme array) {
        for (Filme f : filmes)
            if (f.getId().equals(array.getId())) {
                return true;
            }
        return false;
    }

    public void notaArredondada(Filme filme) {
        if (filme.getNota() > 5) {
            filme.setNota(5);

            int nota = filme.getNota();
            filme.setNota(Math.round(nota));
        }
    }

    // if (this.filmes.toString().contains(filme.getNomeFilme())) {
    public void add(Filme filme) {

        if (this.filmes.toString().contains(filme.toString())) { // Verificando se já existe um filme
            System.out.println("Filme já existe no catálogo!");
            return;
        } else if (!this.filmes.toString().contains(filme.getNomeFilme())
                || filmesRepository.containsID(filme) == true) {
            filme.setId(this.filmes.size() + 1);
            this.filmes.add(filme);
            filmesRepository.notaArredondada(filme); // Arredondar nota
            System.out.println("Filme " + filme.getNomeFilme() + " adicionado com sucesso");
        }
    }
}
