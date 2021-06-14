package br.com.efipee.exceptions;

import java.util.List;

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

@RestController
@RequestMapping("/alunos")
public class ControleAluno {

    AlunosService alunosService = new AlunosService();
    
    // Adicionar Aluno
    @PostMapping
    public ResponseEntity addAluno(@RequestBody Aluno aluno) {
        return alunosService.addAluno(aluno);
}

    // Editar Alunos
    @PutMapping
    public void updateAluno(@RequestBody final Aluno aluno){
        alunosService.editarAluno(aluno);
    }

    // Controle achar Alunos pelo nome 
    @GetMapping
    public List<Aluno> findByNome(@RequestParam(required = false) String nome) {
        return alunosService.acharAlunoNome(nome);
    }

    // Controle Achar Aluno pelo ID || localhost:8080/alunos/{id}
    @GetMapping("{id}")
    public Aluno findById(@PathVariable("id") Integer idLocal){
        return alunosService.findById(idLocal);
    }

    // Controle Achar Aluno pela idade || localhost:8080/alunos/idade/{age}
    @GetMapping("idade/{age}") // Link para filtrar pela idade
    public ResponseEntity findByAge(@PathVariable("age") Integer idade) { 
        return (ResponseEntity) alunosService.findByAge(idade);
    }

    // Deletar aluno pelo id || localhost:8080/{id}
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable("id") Integer id){
        alunosService.deletarAluno(id);
    }
}
