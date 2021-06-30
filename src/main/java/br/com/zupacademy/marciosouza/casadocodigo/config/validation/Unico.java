package br.com.zupacademy.marciosouza.casadocodigo.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DuplicadoValidator.class)
public @interface Unico{

    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String message();
    String fieldName();
    Class<?> clazz();
}
