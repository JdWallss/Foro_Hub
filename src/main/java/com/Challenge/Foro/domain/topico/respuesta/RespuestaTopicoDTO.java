package com.Challenge.Foro.domain.topico.respuesta;

import com.Challenge.Foro.domain.topico.TopicoDTO;
import org.springframework.data.domain.Page;

public record RespuestaTopicoDTO(TopicoDTO topico, Page<RespuestaDTO> respuestas) {
}