package br.com.zupacademy.marciosouza.casadocodigo.config.validation;

import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.CategoriaRequest;
import br.com.zupacademy.marciosouza.casadocodigo.model.Categoria;
import br.com.zupacademy.marciosouza.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeCategoriaDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if(errors.hasErrors()) { return; }

        CategoriaRequest categoriaRequest = (CategoriaRequest) obj;
        Optional<Categoria> categoria = categoriaRepository.getByNome(categoriaRequest.getNome());

        if(categoria.isPresent()){
            errors.rejectValue("nome", null, "nome já existe");
        }
    }
}
