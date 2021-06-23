package br.com.efipee.filmes.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.efipee.filmes.entities.Filme;

public class FilmesRepositoryTest {

    @Test
    public void testarProjeto() {
        Filme filmes = new Filme(1, 2020, 4, "Titanic", "Ítalo");
        String result = filmes.getNomeFilme();
        assertEquals("Titanic", result);
    }

    @Test
    public void testandoProjetoDiretorName() {
        Filme filmes = new Filme(1, 2020, 4, "Titanic", "Ítalo");
        String result = filmes.getDiretor();
        assertEquals("Ítalo", result);
    }

    @Test
    public void testandoProjetoYearValue() {
        Filme filmes = new Filme(1, 2020, 4, "Titanic", "Ítalo");
        Integer result = filmes.getAno();
        assertEquals(2020, result);
    }

    @Test
    public void testandoProjetoGradesValue() {
        Filme filmes = new Filme(1, 2020, 4, "Titanic", "Ítalo");
        Integer result = filmes.getNota();
        assertEquals(4, result);
    }
}
