package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.model.Livro;
import java.math.BigDecimal;

public class LivroResponseDetalhadoFront {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private AutorResponseDetalhadoFront autor;

    public LivroResponseDetalhadoFront(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.autor = new AutorResponseDetalhadoFront(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorResponseDetalhadoFront getAutor() {
        return autor;
    }
}
