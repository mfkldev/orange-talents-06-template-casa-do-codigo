package br.com.zupacademy.marciosouza.cadadocodigo.controller;

import br.com.zupacademy.marciosouza.cadadocodigo.controller.dto.AutorRequest;
import br.com.zupacademy.marciosouza.cadadocodigo.model.Autor;
import br.com.zupacademy.marciosouza.cadadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvar(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok().build();
    }

}
