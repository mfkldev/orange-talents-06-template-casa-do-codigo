package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.model.Pais;

public class PaisResponse {

    private String nome;

    public PaisResponse(Pais pais){
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }
}
