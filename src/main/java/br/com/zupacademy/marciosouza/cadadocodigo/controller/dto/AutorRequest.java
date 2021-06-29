package br.com.zupacademy.marciosouza.cadadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.cadadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorRequest{

    @NotEmpty @NotNull @Email
    private String email;

    @NotEmpty @NotNull
    private String nome;

    @NotEmpty @NotNull @Length(max = 399)
    private String descricao;

    public AutorRequest(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Autor converter() {
        Autor autor = new Autor(this.email, this.nome, this.descricao);
        return autor;
    }
}
