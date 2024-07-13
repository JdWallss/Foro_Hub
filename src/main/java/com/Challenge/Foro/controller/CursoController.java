package com.Challenge.Foro.controller;


import com.Challenge.Foro.domain.curso.ActualizarCursoDTO;
import com.Challenge.Foro.domain.curso.CrearCursoDTO;
import com.Challenge.Foro.domain.curso.CursoDTO;
import com.Challenge.Foro.domain.curso.CursoService;
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
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    @Transactional
    public ResponseEntity crearCurso(@RequestBody @Valid CrearCursoDTO datos) {
        var response = service.crearCurso(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody @Valid ActualizarCursoDTO datos) {
        var response = service.actualizarCurso(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cambiarEstadoCurso(@PathVariable Long id){
        service.cambiarEstado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/activos")
    public ResponseEntity<Page<CursoDTO>> listarCursosActivos(@PageableDefault(size=10) Pageable paginacion) {
        var response = service.listarCursosActivos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<Page<CursoDTO>> listarCursosInactivos(@PageableDefault(size=10) Pageable paginacion) {
        var response = service.listarCursosInactivos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<CursoDTO>> listarCursos(@PageableDefault(size = 10) Pageable paginacion) {
        var response = service.listarCursos(paginacion);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity mostrarCurso(@PageableDefault(size = 10)Pageable paginacion,
//                                       @PathVariable @Valid Long id) {
//        var response = service.mostrarCurso(id, paginacion);
//        return ResponseEntity.ok(response);
//    }
}