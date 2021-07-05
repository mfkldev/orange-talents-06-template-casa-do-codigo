package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Unico;
import br.com.zupacademy.marciosouza.casadocodigo.model.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank @Unico(clazz = Pais.class, fieldName = "nome")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public Pais converter(){
        return new Pais(this.nome);
    }
}
