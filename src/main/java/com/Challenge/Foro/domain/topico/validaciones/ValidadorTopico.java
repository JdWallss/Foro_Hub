package com.Challenge.Foro.domain.topico.validaciones;

import com.Challenge.Foro.domain.topico.CrearTopicoDTO;

public interface ValidadorTopico {
    public void validar(CrearTopicoDTO datos);
}