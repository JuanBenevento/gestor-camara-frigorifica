package com.juan.curso.springboot.webapp.gestorcamarafrigorifica.Validacion;

import com.juan.curso.springboot.webapp.gestorcamarafrigorifica.servicios.UsuarioService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistByUserNameValidation implements ConstraintValidator<ExistByUserName, String> {
    @Autowired
    private UsuarioService service;

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext constraintValidatorContext) {
        return !service.existsByUsername(nombre);
    }
}
