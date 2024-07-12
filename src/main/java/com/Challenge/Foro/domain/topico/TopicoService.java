package com.Challenge.Foro.domain.topico;

import com.Challenge.Foro.domain.curso.ActualizarCursoDTO;
import com.Challenge.Foro.domain.curso.CursoRepository;
import com.Challenge.Foro.domain.topico.respuesta.RespuestaDTO;
import com.Challenge.Foro.domain.topico.respuesta.RespuestaRepository;
import com.Challenge.Foro.domain.topico.respuesta.RespuestaTopicoDTO;
import com.Challenge.Foro.domain.topico.validaciones.ValidadorTopico;
import com.Challenge.Foro.domain.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private List<ValidadorTopico> validarTopico;

    public TopicoDTO crearTopico(CrearTopicoDTO datos) {

        validarTopico.forEach(v -> v.validar(datos));

        var titulo = datos.titulo();
        var mensaje = datos.mensaje();
        var autor = usuarioRepository.getReferenceById(datos.idAutor());
        var curso = cursoRepository.getReferenceById(datos.idCurso());

        var topico = new Topico(titulo, mensaje, autor, curso);

        topicoRepository.save(topico);

        return new TopicoDTO(topico);
    }

    public TopicoDTO actualizarTopico(ActualizarTopicoDTO datos) {

        var topico = topicoRepository.getReferenceById(datos.id());
        topico.actualizarTopico(datos);

        return new TopicoDTO(topico);
    }

    public String eliminarTopico(Long id) {
        var topico = topicoRepository.findById(id);
        if (!topico.isPresent() || id == null) {
            throw new ValidationException("No existe topico con id = " + id);
        }
        //respuestaRepository.removeAllByTopico(topicoRepository.getReferenceById(id));

        topicoRepository.removeById(id);

        return "Topico y respuestas eliminados correctamente.";
    }

    public Page<TopicoDTO> listarTopicos(Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(TopicoDTO::new);
    }

    public RespuestaTopicoDTO mostrarTopico(Long id, Pageable paginacion) {
        if(id == null || !topicoRepository.existsById(id)) {
            throw new ValidationException("no existe topico con ese id");
        }
        var topico = topicoRepository.getReferenceById(id);
        var respuestas = respuestaRepository
                .findAllByTopico(topico, paginacion)
                .map(RespuestaDTO::new);

        return new RespuestaTopicoDTO(new TopicoDTO(topico), respuestas);
    }

    public Page<TopicoDTO> listarTopicosResueltos(Pageable paginacion) {
        var topicosSolucionados = topicoRepository.findAllByStatusTrue(paginacion);
        return topicosSolucionados.map(TopicoDTO::new);
    }

    public Page<TopicoDTO> listarTopicosIrresolutos(Pageable paginacion) {
        var topicosSolucionados = topicoRepository.findAllByStatusFalse(paginacion);
        return topicosSolucionados.map(TopicoDTO::new);
    }
}
