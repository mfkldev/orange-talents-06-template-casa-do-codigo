package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.config.exceptions.EstadoIllegalArumentExcpetion;
import br.com.zupacademy.marciosouza.casadocodigo.config.validation.CpfCnpj;
import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Existente;
import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Unico;
import br.com.zupacademy.marciosouza.casadocodigo.model.Cliente;
import br.com.zupacademy.marciosouza.casadocodigo.model.Estado;
import br.com.zupacademy.marciosouza.casadocodigo.model.Pais;
import br.com.zupacademy.marciosouza.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.marciosouza.casadocodigo.repository.PaisRepository;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequest {

    @NotBlank
    @Email
    @Unico(fieldName = "email", clazz = Cliente.class)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank @CpfCnpj
    @Unico(fieldName = "documento", clazz = Cliente.class)
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull @Existente(clazz = Pais.class, fieldName = "id")
    private Long idPais;

    private Long idEstado;

    @NotBlank
    private String cep;

    @NotBlank
    private String telefone;

    public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long idPais, Long idEstado, String cep, String telefone) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.cep = cep;
        this.telefone = telefone;
    }

    public Cliente converter(EstadoRepository estadoRepository, PaisRepository paisRepository){
        Pais pais = paisRepository.getById(idPais);
        Optional<Estado> optionalEstado;
        Estado estado = null;

        if(this.idEstado == null){
            verificaSePaisTemEstado(pais);
        }else{
            optionalEstado = estadoRepository.findById(idEstado);
            estado = optionalEstado.orElseThrow(() -> new EstadoIllegalArumentExcpetion("O estado não está cadastrado no banco"));
            verificaSeEstadoEDoPais(pais, estado);
        }

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento,
                this.endereco, this.complemento, this.cidade, pais, estado, this.cep, this.telefone);
    }

    private void verificaSeEstadoEDoPais(Pais pais, Estado estado) {
        if(!pais.getEstado().contains(estado)){
            throw new EstadoIllegalArumentExcpetion("O estado não pertence ao país");
        }
    }

    private void verificaSePaisTemEstado(Pais pais) {
        if(pais.getEstado() != null){
           throw new EstadoIllegalArumentExcpetion("Precisa escolher um estado, pois esse pais tem estados");
        }
    }
}
