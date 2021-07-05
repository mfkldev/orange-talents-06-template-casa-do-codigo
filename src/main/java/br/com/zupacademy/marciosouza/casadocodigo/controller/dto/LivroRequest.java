package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Existente;
import br.com.zupacademy.marciosouza.casadocodigo.config.validation.Unico;
import br.com.zupacademy.marciosouza.casadocodigo.model.Autor;
import br.com.zupacademy.marciosouza.casadocodigo.model.Categoria;
import br.com.zupacademy.marciosouza.casadocodigo.model.Livro;
import br.com.zupacademy.marciosouza.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marciosouza.casadocodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank @Unico(clazz = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank @Length(max = 500)
    private String resumo;

    private String sumario;

    private @NotNull @Min(20)
    BigDecimal preco;

    @NotNull @Min(100)
    private Integer numeroDePaginas;

    @NotBlank @Unico(clazz = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataIrAoAr;

    @NotNull @Existente(fieldName = "id", clazz = Categoria.class)
    private Long idCategoria;

    @NotNull @Existente(fieldName = "id", clazz = Autor.class)
    private Long idAutor;

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository){

        Autor autor = autorRepository.getById(idAutor);
        Categoria categoria = categoriaRepository.getById(idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco,
            this.numeroDePaginas, this.isbn, this.dataIrAoAr,
            categoria, autor);
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }
}
