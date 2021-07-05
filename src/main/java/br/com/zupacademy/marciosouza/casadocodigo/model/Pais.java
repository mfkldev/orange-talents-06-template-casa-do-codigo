package br.com.zupacademy.marciosouza.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estado = new ArrayList<>();

    @OneToMany(mappedBy = "pais")
    private List<Cliente> clientes = new ArrayList<>();

    @Deprecated
    public Pais() {}

    public Pais(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Estado> getEstado() {
        return estado;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }
}
