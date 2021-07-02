package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.model.Autor;

public class AutorResponse {

    private String email;
    private String nome;
    private String descricao;

    public AutorResponse(Autor autor) {
        this.email = autor.getEmail();
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
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
