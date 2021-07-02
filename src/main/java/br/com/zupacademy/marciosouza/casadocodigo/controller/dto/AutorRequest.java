package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Unico;
import br.com.zupacademy.marciosouza.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorRequest{

    @NotBlank @Email @Unico(clazz = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank @Length(max = 399)
    private String descricao;

    public AutorRequest(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(this.email, this.nome, this.descricao);
    }
}
