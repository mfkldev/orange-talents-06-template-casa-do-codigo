package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Unico;
import br.com.zupacademy.marciosouza.casadocodigo.model.Categoria;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaRequest {

    @NotEmpty @NotNull @Unico(clazz = Categoria.class, fieldName = "nome", message = "Categoria já existente")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public Categoria converter(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return  this.nome;
    }
}
