package br.com.zupacademy.marciosouza.casadocodigo.model;

import javax.persistence.*;

@Entity
public class Categoria {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;

    @Column(nullable = false)
    private String nome;

    @Deprecated
    private Categoria(){}

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }


}
