package br.com.zupacademy.marciosouza.casadocodigo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @Column(nullable = false) LocalDateTime dataCriacao = LocalDateTime.now();
    private @Column(nullable = false) String email;
    private @Column(nullable = false) String nome;
    private @Column(nullable = false, length = 400) String descricao;

    @Deprecated
    public Autor(){}

    public Autor(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}

