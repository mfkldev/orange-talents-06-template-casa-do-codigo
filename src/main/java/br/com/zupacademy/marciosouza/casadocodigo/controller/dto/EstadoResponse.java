package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.model.Estado;
import br.com.zupacademy.marciosouza.casadocodigo.model.Pais;

public class EstadoResponse {

    private String nome;
    private String nomePais;

    public EstadoResponse(Estado estado) {
        this.nome = estado.getNome();
        this.nomePais = estado.getPais().getNome();
    }

    public String getNome() {
        return nome;
    }

    public String getNomePais() {
        return nomePais;
    }
}
