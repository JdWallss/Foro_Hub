package com.Challenge.Foro.domain.curso.validaciones;

import com.Challenge.Foro.domain.curso.CrearCursoDTO;
import com.Challenge.Foro.domain.curso.CursoRepository;
import com.Challenge.Foro.infra.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoExistenteValidacionCurso implements ValidadorCurso {

    @Autowired
    CursoRepository repository;

    @Override
    public void validar(CrearCursoDTO datos) {
        if (repository.existsByNombre(datos.nombre())) {
            throw new ValidationException("Ya existe un curso con ese nombre");
        }
        if (datos.nombre() == null) {
            throw new ValidacionDeIntegridad("El nombre del curso no puede quedar vacio");
        }
    }
}