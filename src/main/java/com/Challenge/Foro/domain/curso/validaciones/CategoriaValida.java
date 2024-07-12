package com.Challenge.Foro.domain.curso.validaciones;

import com.Challenge.Foro.domain.curso.CrearCursoDTO;
import com.Challenge.Foro.infra.ValidacionDeIntegridad;
import org.springframework.stereotype.Component;

@Component
public class CategoriaValida implements ValidadorCurso{

    @Override
    public void validar(CrearCursoDTO datos) {
        if (datos.categoria() == null) {
            throw new ValidacionDeIntegridad("Debe asignarle una categoria al curso");
        }
        //Valida el  Enum
    }
}