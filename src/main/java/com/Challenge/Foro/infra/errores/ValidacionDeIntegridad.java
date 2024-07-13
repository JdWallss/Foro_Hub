package com.Challenge.Foro.infra.errores;

public class ValidacionDeIntegridad  extends RuntimeException {
    public ValidacionDeIntegridad(String s) {
        super(s);
    }
}