package br.com.zupacademy.marciosouza.casadocodigo.controller;

import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.LivroRequest;
import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.LivroResponse;
import br.com.zupacademy.marciosouza.casadocodigo.model.Livro;
import br.com.zupacademy.marciosouza.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marciosouza.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.marciosouza.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest){
        Livro livro = livroRequest.converterReqToLivro(autorRepository, categoriaRepository);

        livroRepository.save(livro);

        LivroResponse livroResponse = new LivroResponse(livro);

        return ResponseEntity.ok().body(livroResponse);
    }
}
