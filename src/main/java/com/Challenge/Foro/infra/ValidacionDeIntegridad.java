package com.Challenge.Foro.infra;

public class ValidacionDeIntegridad  extends RuntimeException {
    public ValidacionDeIntegridad(String s) {
        super(s);
    }
}