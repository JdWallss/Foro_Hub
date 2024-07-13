package com.Challenge.Foro.domain.topico.respuesta.validaciones;

import com.Challenge.Foro.domain.topico.TopicoRepository;
import com.Challenge.Foro.domain.topico.respuesta.CrearRespuestaDTO;
import com.Challenge.Foro.domain.topico.respuesta.RespuestaRepository;
import com.Challenge.Foro.domain.usuario.UsuarioRepository;
import com.Challenge.Foro.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaValida  implements ValidarRespuesta {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(CrearRespuestaDTO datos) {
        if (datos.mensaje() == null) {
            throw new ValidacionDeIntegridad("mensaje no encontrado");
        }

        if (respuestaRepository.existsByTopicoAndMensajeAndAutorRespuesta(
                topicoRepository.getReferenceById(datos.idTopico()),
                datos.mensaje(),
                usuarioRepository.getReferenceById(datos.idAutor()))) {
            throw new ValidationException("Ya existe una respuesta igual para el topico");
        }
    }
}