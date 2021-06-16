package br.com.efipee.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoService {

    private final List<Aluno> alunos;
    private String id;

    public AlunoService(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    // Postar Aluno

    @PostMapping
    public ResponseEntity addAluno(@RequestBody Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(alunos.size() + 1);
        }
        if (alunos.contains(aluno)) {
            ; // Verificar se já existe um aluno com o nome cadastrado na váriavel (aluno)
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Eibir código 409
        }
        alunos.add(aluno); // Cadastrar aluno
        return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED);
    }

    public int codigo(String a) {
        return a.hashCode();
    }

    // Filtrar por Nome

    @GetMapping
    public List<Aluno> acharAlunoNome(@RequestParam(required = false) String nome)
            throws RecursoNaoEncontradoException {

        if (nome == null || nome == "") {
            return alunos;
        }

        for (Aluno pi : alunos) {
            if (nome.equals(pi)) {

                return alunos.stream()
                .filter(aluno -> aluno.getNome()
                .contains(nome))
                .collect(Collectors.toList());

            } else if (nome != null || nome != "") {
                throw new RecursoNaoEncontradoException();
            }
        }

        throw new RecursoNaoEncontradoException();
    }

}
