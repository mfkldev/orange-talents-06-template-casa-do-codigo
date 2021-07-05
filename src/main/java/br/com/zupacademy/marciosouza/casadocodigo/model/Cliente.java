package br.com.zupacademy.marciosouza.casadocodigo.model;

import br.com.zupacademy.marciosouza.casadocodigo.config.validation.CpfCnpj;
import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Unico;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank @CpfCnpj
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull @ManyToOne(fetch = FetchType.EAGER)
    private Pais pais;

    @ManyToOne(fetch = FetchType.EAGER)
    private Estado estado;

    @NotBlank
    private String cep;

    @NotBlank
    private String telefone;

    @Deprecated
    private Cliente(){}

    public Cliente(String email, String nome, String sobrenome, String documento,
                   String endereco, String complemento, String cidade, Pais pais,
                   Estado estado, String cep, String telefone) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }
}
