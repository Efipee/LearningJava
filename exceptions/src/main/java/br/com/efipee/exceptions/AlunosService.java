package br.com.efipee.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class AlunosService {

    private final List<Aluno> alunos;

    public AlunosService() {
        this.alunos = new ArrayList<>();
    }

    // Cadastrar Aluno
    public ResponseEntity addAluno(Aluno aluno) {

        if (aluno.getId() == null) {
            aluno.setId(alunos.size() + 1);
        }
        if (alunos.contains(aluno)) {
            ; // Verificar se já existe um aluno com o nome cadastrado na váriavel (aluno)
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Eibir código 409
        }
        alunos.add(aluno); // Cadastrar aluno
        return new ResponseEntity<>("Aluno " + aluno.getNome() +" adicionado com Sucesso! ID do aluno:"+ aluno.getId(), HttpStatus.CREATED);
    }

    // Editar Aluno
    public void editarAluno(@RequestBody final Aluno aluno) {
        alunos.stream()
        .filter(student -> student.getId().equals(aluno.getId()))
        .forEach(student -> student.setNome(aluno.getNome()));

        alunos.stream()
        .filter(student -> student.getId().equals(aluno.getId()))
        .forEach(student -> student.setAge(aluno.getAge()));

    }

    // Controle achar Alunos pelo nome
    public List<Aluno> acharAlunoNome(String nome) {
        String resultado = alunos.toString();

        if (nome != null && resultado.contains(nome)) {
            return alunos.stream()
            .filter(aluno -> aluno.getNome().contains(nome))
            .collect(Collectors.toList());
        } else if (nome == null || nome == "") {
            return alunos;
        }
        throw new RecursoInexistenteException();
    }

    // Achar aluno por idade
    public List<Aluno> findByAge(Integer idade) {
        if (idade != null) { // Se idade foi nula retornar ¹
            return alunos.stream() // Retornar lista de alunos
            .filter(age -> age.getAge().equals(idade)) // Filtrando se Integer idade for igual (equals) a age                                     
            .collect(Collectors.toList());
        }
        return alunos; // ¹ retorar alunos
    }

    // Controle achar Alunos pelo ID
    public Aluno findById(Integer idLocal) {
        return this.alunos.stream()
        .filter(id -> id.getId().equals(idLocal))
        .findFirst()
        .orElseThrow(() -> new RecursoInexistenteException());
    }

    // Deletar Cadastro Aluno
    public ResponseEntity deletarAluno(Integer id){
        alunos.removeIf(aluno -> aluno.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }    

}
