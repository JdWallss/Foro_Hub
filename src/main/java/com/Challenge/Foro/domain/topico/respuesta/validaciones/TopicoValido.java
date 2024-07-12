package com.Challenge.Foro.domain.topico.respuesta.validaciones;

import com.Challenge.Foro.domain.topico.TopicoRepository;
import com.Challenge.Foro.domain.topico.respuesta.CrearRespuestaDTO;
import com.Challenge.Foro.infra.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoValido implements ValidarRespuesta {

    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(CrearRespuestaDTO datos) {
        if (datos.idTopico() == null || !topicoRepository.existsById(datos.idTopico())) {
            throw new ValidacionDeIntegridad("Topico no encontrado");
        }
    }
}