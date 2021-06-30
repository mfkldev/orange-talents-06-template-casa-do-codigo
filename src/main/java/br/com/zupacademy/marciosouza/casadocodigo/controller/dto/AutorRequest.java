package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Unico;
import br.com.zupacademy.marciosouza.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorRequest{

    @NotEmpty @NotNull @Email @Unico(clazz = Autor.class, fieldName = "email", message = "Autor já existente")
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
        return new Autor(this.email, this.nome, this.descricao);
    }

    public String getEmail() {
        return this.email;
    }
}
