package com.Challenge.Foro.domain.topico;

import jakarta.validation.constraints.NotNull;

public record ActualizarTopicoDTO(
        @NotNull
        Long id,
        String titulo,
        String mensaje
) {
}