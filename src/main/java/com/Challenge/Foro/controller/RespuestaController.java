package com.Challenge.Foro.controller;

import com.Challenge.Foro.domain.topico.respuesta.CrearRespuestaDTO;
import com.Challenge.Foro.domain.topico.respuesta.EditarRespuestaDTO;
import com.Challenge.Foro.domain.topico.respuesta.EstadoRespuestaDTO;
import com.Challenge.Foro.domain.topico.respuesta.RespuestaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    @PostMapping
    @Transactional
    public ResponseEntity crearRespuesta(@RequestBody @Valid CrearRespuestaDTO datos) {
        var response = service.crearRespuesta(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid EditarRespuestaDTO datos) {
        var response = service.editarRespuesta(datos);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity cambiarEstadoRespuesta(@PathVariable Long id) {
        EstadoRespuestaDTO response = service.marcarDesmarcarComoSolucion(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        service.eliminarRespuesta(id);
        return ResponseEntity.ok().build();
    }
}