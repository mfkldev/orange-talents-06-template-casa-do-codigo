package br.com.zupacademy.marciosouza.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;

    @NotBlank @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> listaLivro = new ArrayList<>();

    @Deprecated
    public Categoria(){}

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
