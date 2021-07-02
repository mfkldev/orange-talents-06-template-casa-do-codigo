package br.com.zupacademy.marciosouza.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank @Length(max = 500) @Column(length = 500, nullable = false)
    private String resumo;

    private String sumario;

    private @NotNull @Min(20) @Column(nullable = false)
    BigDecimal preco;

    @NotNull @Min(100) @Column(nullable = false)
    private Integer numeroDePaginas;

    @NotBlank @Column(nullable = false, unique = true)
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataIrAoAr;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;

    @Deprecated
    public Livro(){}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas, String isbn, LocalDate dataIrAoAr, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataIrAoAr = dataIrAoAr;
        this.categoria = categoria;
        this.autor = autor;
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

    public LocalDate getDataIrAoAr() {
        return dataIrAoAr;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
