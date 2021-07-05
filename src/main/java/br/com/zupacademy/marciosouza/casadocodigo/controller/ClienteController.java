package br.com.zupacademy.marciosouza.casadocodigo.controller;

import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.ClienteRequest;
import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.ClienteResponse;
import br.com.zupacademy.marciosouza.casadocodigo.model.Cliente;
import br.com.zupacademy.marciosouza.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.marciosouza.casadocodigo.repository.EstadoRepository;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.converter(estadoRepository, paisRepository);

        clienteRepository.save(cliente);

        return ResponseEntity.ok(new ClienteResponse(cliente));
    }
}
