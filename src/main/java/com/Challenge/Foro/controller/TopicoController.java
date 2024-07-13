package com.Challenge.Foro.controller;

import com.Challenge.Foro.domain.topico.ActualizarTopicoDTO;
import com.Challenge.Foro.domain.topico.CrearTopicoDTO;
import com.Challenge.Foro.domain.topico.TopicoDTO;
import com.Challenge.Foro.domain.topico.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity crearTopico(@RequestBody @Valid CrearTopicoDTO datos) {
        var response = service.crearTopico(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid ActualizarTopicoDTO datos) {
        var response = service.actualizarTopico(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        var response = service.eliminarTopico(id);
        return ResponseEntity.ok(response);
    }


    //Implementacion de pages y listado
    @GetMapping
    public ResponseEntity<Page<TopicoDTO>> listarTopicos(@PageableDefault(size = 10)Pageable paginacion) {
        var response = service.listarTopicos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/resueltos")
    public ResponseEntity<Page<TopicoDTO>> listarTopicosResueltos(@PageableDefault(size = 10) Pageable paginacion) {
        var response = service.listarTopicosResueltos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/irresolutos")
    public ResponseEntity<Page<TopicoDTO>> listarTopicosIrresolutos(@PageableDefault(size = 10) Pageable paginacion) {
        var response = service.listarTopicosIrresolutos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarTopicoRespuestas(@PageableDefault(size = 10)Pageable paginacion,
                                                  @PathVariable Long id) {
        var response = service.mostrarTopico(id, paginacion);
        return ResponseEntity.ok(response);
    }
}