package br.com.zupacademy.marciosouza.cadadocodigo.controller.validation;

import br.com.zupacademy.marciosouza.cadadocodigo.controller.dto.AutorRequest;
import br.com.zupacademy.marciosouza.cadadocodigo.model.Autor;
import br.com.zupacademy.marciosouza.cadadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Optional;

@Component
public class EmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) { //Qual o tipo de parametro que vai receber essa validação
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if(errors.hasErrors()){ //Se já existe erro de validação não roda esta validação
            return;
        }

        AutorRequest autorRequest = (AutorRequest) obj;
        Optional<Autor> autorDoBanco = autorRepository.findByEmail(autorRequest.getEmail());

        if (autorDoBanco.isPresent()){
            errors.rejectValue("email", null, "e-mail já existente");
        }
    }
}
