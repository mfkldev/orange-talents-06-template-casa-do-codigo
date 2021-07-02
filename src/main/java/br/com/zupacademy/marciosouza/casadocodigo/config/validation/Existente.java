package br.com.zupacademy.marciosouza.casadocodigo.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistenteValidator.class)
public @interface Existente {

    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String message() default "Valor de atributo não encontrado";
    String fieldName();
    Class<?> clazz();
}
