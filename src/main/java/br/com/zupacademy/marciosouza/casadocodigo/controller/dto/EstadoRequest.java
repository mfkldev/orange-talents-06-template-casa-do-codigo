package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.config.exceptions.EstadoIllegalArumentExcpetion;
import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Existente;
import br.com.zupacademy.marciosouza.casadocodigo.model.Estado;
import br.com.zupacademy.marciosouza.casadocodigo.model.Pais;
import br.com.zupacademy.marciosouza.casadocodigo.repository.PaisRepository;
import com.sun.istack.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;

public class EstadoRequest {

    @NotBlank
    private String nome;

    @NotNull @Existente(fieldName = "id", clazz = Pais.class)
    private Long idPais;


    public EstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado converter(PaisRepository paisRepository, EntityManager entityManager){

        verificarEstadoRepetidoNoMesmoPais(paisRepository, entityManager);

        Pais pais = paisRepository.getById(idPais);

        return new Estado(this.nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void verificarEstadoRepetidoNoMesmoPais(PaisRepository paisRepository, EntityManager entityManager) {

        String JPQL = "SELECT e FROM Estado e WHERE e.pais.id = :pIdPais AND e.nome = :pNomeEstado";

        Query query = entityManager.createQuery(JPQL);
        query.setParameter("pIdPais", this.idPais);
        query.setParameter("pNomeEstado", this.nome);

        if (!query.getResultList().isEmpty()) {
            throw new EstadoIllegalArumentExcpetion("Estado já existente nesse país!");
        }
    }
}
