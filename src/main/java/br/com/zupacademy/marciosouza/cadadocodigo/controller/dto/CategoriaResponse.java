package br.com.zupacademy.marciosouza.cadadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.cadadocodigo.model.Categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaResponse {

    private @NotEmpty @NotNull String nome;

    public CategoriaResponse(Categoria categoria){
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
