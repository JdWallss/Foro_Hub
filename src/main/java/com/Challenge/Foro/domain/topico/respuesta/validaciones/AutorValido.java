package com.Challenge.Foro.domain.topico.respuesta.validaciones;

import com.Challenge.Foro.domain.topico.respuesta.CrearRespuestaDTO;
import com.Challenge.Foro.domain.usuario.UsuarioRepository;
import com.Challenge.Foro.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;

public class AutorValido implements ValidarRespuesta {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void validar(CrearRespuestaDTO datos) {
        if (datos.idAutor() == null || !usuarioRepository.existsById(datos.idAutor())) {
            throw new ValidacionDeIntegridad("Autor no encontrado");
        }
    }
}