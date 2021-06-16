package br.com.efipee.Aluno;

public class Aluno {

    private Integer id;
    private String nome;
    private Integer age;

    private String comparar;

    //Constructor
    public Aluno(final Integer id, final String nome, final Integer age) {
        this.id = id;
        this.nome = nome;
        this.age = age;
    }


    // Getter's e Setter's
    public Integer getId() {
    	return this.id;
    }
    public void setId(Integer id) {
    	this.id = id;
    }

    public String getNome() {
    	return this.nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }

    public String getComparar() {
    	return this.comparar;
    }
    public void setComparar(String comparar) {
    	this.comparar = comparar;
    }


    public Integer getAge() {
    	return this.age;
    }
    public void setAge(Integer age) {
    	this.age = age;
    }



    
}
