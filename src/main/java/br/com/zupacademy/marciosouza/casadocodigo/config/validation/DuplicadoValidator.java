package br.com.zupacademy.marciosouza.casadocodigo.config.validation;

import br.com.zupacademy.marciosouza.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class DuplicadoValidator implements ConstraintValidator<Unico, String>{

    @Autowired
    private EntityManager entityManager;
    private Class<?> clazz;
    private String fieldName;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(Unico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.fieldName = constraintAnnotation.fieldName();
        this.clazz = constraintAnnotation.clazz();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String jpql = "SELECT x FROM " + clazz.getName() + " x WHERE x." + fieldName + " = :pCampo";
        Query query = entityManager.createQuery(jpql).setParameter("pCampo", value);
        List<Object> list = query.getResultList();

        return list.isEmpty();
    }
}
