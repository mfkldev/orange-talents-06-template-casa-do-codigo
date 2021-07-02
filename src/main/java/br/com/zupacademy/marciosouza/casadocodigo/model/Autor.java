package br.com.zupacademy.marciosouza.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    private @Column(nullable = false) LocalDateTime dataCriacao = LocalDateTime.now();
    private  @NotBlank @Column(nullable = false, unique = true) String email;
    private @NotBlank @Column(nullable = false) String nome;
    private @Column(nullable = false, length = 400) String descricao;

    @OneToMany(mappedBy = "autor")
    private List<Livro> listaDeLivro = new ArrayList<>();

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

