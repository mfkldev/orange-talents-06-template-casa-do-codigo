package br.com.zupacademy.marciosouza.casadocodigo.controller.dto;

import br.com.zupacademy.marciosouza.casadocodigo.model.Autor;
import br.com.zupacademy.marciosouza.casadocodigo.model.Categoria;
import br.com.zupacademy.marciosouza.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Future;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroResponseIdETitulo {

    private String titulo;
    private Long id;

    public LivroResponseIdETitulo(Livro livro) {
        this.titulo = livro.getTitulo();
        this.id = livro.getId();
    }

    public static Page<LivroResponseIdETitulo> ConvertePageLivroToPageDto(Page<Livro> pageLivro) {
        return pageLivro.map(LivroResponseIdETitulo::new);
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() { return id; }

}
