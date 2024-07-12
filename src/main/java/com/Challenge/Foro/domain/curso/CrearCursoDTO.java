package com.Challenge.Foro.domain.curso;

import jakarta.validation.constraints.NotNull;

public record CrearCursoDTO(
        @NotNull
        String nombre,
        @NotNull
        Categoria categoria
) {
}