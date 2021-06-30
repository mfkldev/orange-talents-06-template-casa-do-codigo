package br.com.zupacademy.marciosouza.cadadocodigo.controller;

import br.com.zupacademy.marciosouza.cadadocodigo.controller.dto.AutorRequest;
import br.com.zupacademy.marciosouza.cadadocodigo.controller.dto.AutorResponse;
import br.com.zupacademy.marciosouza.cadadocodigo.model.Autor;
import br.com.zupacademy.marciosouza.cadadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import br.com.zupacademy.marciosouza.cadadocodigo.config.validation.EmailAutorDuplicadoValidator;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EmailAutorDuplicadoValidator emailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorResponse> salvar(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok().body(new AutorResponse(autor));
    }

}
