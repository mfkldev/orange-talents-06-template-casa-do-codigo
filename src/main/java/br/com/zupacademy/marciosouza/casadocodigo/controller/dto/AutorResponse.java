package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorResponse {

    private @NotEmpty @NotNull @Email String email;
    private @NotEmpty @NotNull String nome;
    private @NotEmpty @NotNull @Length(max = 399) String descricao;

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
