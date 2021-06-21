package br.com.efipee.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.efipee.filmes.entities.Filme;
import br.com.efipee.filmes.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmesController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> listarFilmes(@RequestParam(required = false) String movie) {
        return filmeService.listarFilmes(movie);
    }

    @GetMapping("/{id}")
    public Filme acharPeloId(@PathVariable("id") Integer id) {
        return filmeService.acharPeloId(id);
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Filme filme) {
        filmeService.add(filme);
        return new ResponseEntity<>(filme.getId(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Filme filme) {
        filmeService.update(filme);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        filmeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
