package br.com.zupacademy.marciosouza.casadocodigo.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistenteValidator implements ConstraintValidator<Existente, Long>{

    @Autowired
    private EntityManager entityManager;
    private Class<?> clazz;
    private String fieldName;

    @Override
    public void initialize(Existente constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.fieldName = constraintAnnotation.fieldName();
        this.clazz = constraintAnnotation.clazz();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        String jpql = "SELECT x  FROM " + clazz.getName() + " x WHERE x." + fieldName + " = :pCampo";
        Query query = entityManager.createQuery(jpql).setParameter("pCampo", value);
        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}
