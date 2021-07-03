package br.com.zupacademy.marciosouza.casadocodigo.controller;

import br.com.zupacademy.marciosouza.casadocodigo.config.exceptions.EstadoCadastradoNoPaisException;
import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.EstadoRequest;
import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.EstadoResponse;
import br.com.zupacademy.marciosouza.casadocodigo.model.Estado;
import br.com.zupacademy.marciosouza.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.marciosouza.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest){
        try {
            estadoRequest.verificarEstadoRepetidoNoMesmoPais(paisRepository, entityManager);

            Estado estado = estadoRequest.converter(paisRepository);

            estadoRepository.save(estado);

            return ResponseEntity.ok(new EstadoResponse(estado));

        } catch (EstadoCadastradoNoPaisException e) {
            throw new EstadoCadastradoNoPaisException("Você tentou cadastrar um estado que já existe nesse país!");
        }
    }
}
