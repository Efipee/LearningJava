package br.com.efipee.filmes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.efipee.filmes.entities.Filme;
import br.com.efipee.filmes.repositories.FilmesRepository;

@Service
public class FilmeService implements IFilmesService {

    private FilmesRepository filmesRepository = FilmesRepository.getInstance();

    public List<Filme> listarFilmes(String movie) {
        if (movie != null) {
            return filmesRepository.listarFilmes(movie);
        }
        return filmesRepository.listarFilmes();
    }

    public Filme acharPeloId(Integer id) {
        return filmesRepository.acharPeloId(id);
    }

    public void update(final Filme filme) {
        filmesRepository.update(filme);
    }

    public void delete(Integer id) {
        filmesRepository.delete(id);
    }

    public Integer add(Filme filme) {
        filmesRepository.verifyId(filme);
        filmesRepository.add(filme);
        return filme.getId();
    }




}
