package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;
import br.com.zupacademy.marciosouza.casadocodigo.model.Cliente;
import br.com.zupacademy.marciosouza.casadocodigo.model.Estado;
import br.com.zupacademy.marciosouza.casadocodigo.model.Pais;

public class ClienteResponse {

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private String pais;
    private String estado;
    private String cep;
    private String telefone;

    public ClienteResponse(Cliente cliente) {
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.documento = cliente.getDocumento();
        this.endereco = cliente.getEndereco();
        this.complemento = cliente.getComplemento();
        this.cidade = cliente.getCidade();
        this.pais = cliente.getPais().getNome();
        this.estado = cliente.getEstado().getNome();
        this.cep = cliente.getCep();
        this.telefone = cliente.getTelefone();
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

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }
}
