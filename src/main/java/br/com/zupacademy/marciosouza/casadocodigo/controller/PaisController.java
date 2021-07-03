package br.com.zupacademy.marciosouza.casadocodigo.controller;

import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.PaisRequest;
import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.PaisResponse;
import br.com.zupacademy.marciosouza.casadocodigo.model.Pais;
import br.com.zupacademy.marciosouza.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid  PaisRequest paisRequest){
        Pais pais = paisRequest.converter();
        paisRepository.save(pais);

        return ResponseEntity.ok(new PaisResponse(pais));
    }
}
