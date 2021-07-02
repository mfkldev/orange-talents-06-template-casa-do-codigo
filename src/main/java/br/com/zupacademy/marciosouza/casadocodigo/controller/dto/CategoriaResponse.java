package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaResponse {

    private @NotBlank String nome;

    public CategoriaResponse(Categoria categoria){
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
