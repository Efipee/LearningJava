package br.com.efipee.filmes.entities;

public class Filme {

    private Integer id;
    private Integer ano;
    private Integer nota;
    private String nomeFilme;
    private String diretor;

    public Filme(Integer id, Integer ano, Integer nota, String nomeFilme, String diretor) {
        this.setId(id);
        this.setAno(ano);
        this.setNota(nota);
        this.setNomeFilme(nomeFilme);
        this.setDiretor(diretor);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return this.getNomeFilme() + this.getDiretor();

    }

}
