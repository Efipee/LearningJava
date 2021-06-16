package br.com.efipee.Aluno;

import java.util.ArrayList;
import java.util.List;


public class ControleAlunos {

    // atributo
    private List<Aluno> alunos;

    // Construtor
    public ControleAlunos() {
        this.alunos = new ArrayList<>();

        Aluno aluno1 = new Aluno(1, "Pocahontas", 27);
        Aluno aluno2 = new Aluno(2, "Thais", 18);
        Aluno aluno3 = new Aluno(3, "Juliete", 30);
        Aluno aluno4 = new Aluno(4, "Vitube", 16);
        Aluno aluno5 = new Aluno(5, "Carla Dias", 22);

        this.alunos.add(aluno1);
        this.alunos.add(aluno2);
        this.alunos.add(aluno3);
        this.alunos.add(aluno4);
        this.alunos.add(aluno5);
    }

    public List<Aluno> getAluno() {
        return alunos;
    }

    public void setAluno(List<Aluno> aluno) {
        this.alunos = aluno;
    }
}