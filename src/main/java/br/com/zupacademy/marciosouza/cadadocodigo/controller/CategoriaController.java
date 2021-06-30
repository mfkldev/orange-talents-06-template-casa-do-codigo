package br.com.zupacademy.marciosouza.cadadocodigo.controller;

import br.com.zupacademy.marciosouza.cadadocodigo.controller.dto.CategoriaRequest;
import br.com.zupacademy.marciosouza.cadadocodigo.controller.dto.CategoriaResponse;
import br.com.zupacademy.marciosouza.cadadocodigo.config.validation.NomeCategoriaDuplicadoValidator;
import br.com.zupacademy.marciosouza.cadadocodigo.model.Categoria;
import br.com.zupacademy.marciosouza.cadadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private NomeCategoriaDuplicadoValidator nomeCategoriaDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(nomeCategoriaDuplicadoValidator);
    }

    @PostMapping @Transactional
    public ResponseEntity<CategoriaResponse> salvar(@RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRequest.converter();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().body(new CategoriaResponse(categoria));
    }
}