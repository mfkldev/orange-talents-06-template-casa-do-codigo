package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Duplicado;
import br.com.zupacademy.marciosouza.casadocodigo.model.Categoria;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank @Duplicado(clazz = Categoria.class, fieldName = "nome")
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
