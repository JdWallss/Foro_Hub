package com.Challenge.Foro.domain.topico.respuesta;

public record RespuestaDTO(Long id, String mensaje, Long idTopico, Long idAutor, Boolean solucionado) {

public RespuestaDTO(Respuesta respuesta) {
    this(respuesta.getId(),
            respuesta.getMensaje(),
            respuesta.getTopico().getId(),
            respuesta.getAutorRespuesta().getId(),
            respuesta.getSolucion());
}
}