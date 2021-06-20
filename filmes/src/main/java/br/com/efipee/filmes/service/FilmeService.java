package br.com.efipee.filmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.efipee.filmes.entities.Filme;
import br.com.efipee.filmes.processors.Processor;
import br.com.efipee.filmes.repositories.FilmesRepository;

@Service
public class FilmeService implements IFilmesService {

    private FilmesRepository filmesRepository = FilmesRepository.getInstance();

    @Autowired
    private List<Processor> processors;

    public List<Filme> listarFilmes(String movie) {
        if (movie != null) {
            return filmesRepository.listarFilmes(movie);
        }
        return filmesRepository.listarFilmes();
    }

    public Filme acharPeloId(Integer id) {
        return filmesRepository.acharPeloId(id);
    }

    public Integer add(Filme movie) {
        System.out.println(movie);
        filmesRepository.add(movie);
        // if (movie.getId() == null) {
        //     movie.setId(filmesRepository.count() + 1);
        // }
        // filmesRepository.add(movie);
        // return movie.getId();
        return null;
    }

    public void update(final Filme filme) {
        filmesRepository.update(filme);
    }

    public void delete(Integer id) {
        filmesRepository.delete(id);
    }
}
