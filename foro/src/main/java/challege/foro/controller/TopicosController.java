package challege.foro.controller;
import challege.foro.domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.function.Function;

@RestController// Indica que esta clase es un controlador de REST
@RequestMapping("/topicos")// Define la ruta base para todas las solicitudes que manejará este controlador
public class TopicosController {
    @Autowired// Inyecta automáticamente una instancia de MedicoRepository
    private TopicosRepository topicosRepository;

    @PostMapping
    @Transactional// Indica que el método debe ejecutarse dentro de una transacción
    public ResponseEntity<DatosRespuestaTopicos> registroTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopicos,
                                                                UriComponentsBuilder uriComponentsBuilder){
    Topicos topicos = topicosRepository.save(new Topicos(datosRegistroTopicos));
    DatosRespuestaTopicos datosRespuestaTopicos = new DatosRespuestaTopicos(topicos.getId(), topicos.getTitulo(),
            topicos.getMensaje(),topicos.getFecha(),topicos.getAutor(),topicos.getCurso(),topicos.getStatus());

        // Construye la URI del recurso creado
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicos.getId()).toUri();
        // Devuelve una respuesta con la URI del recurso creado y los datos del médico
        return ResponseEntity.created(url).body(datosRespuestaTopicos);
    }
    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopicos>> listarTopicos(@RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "10") int size) {
        // Crear una instancia de PageRequest con la página, tamaño y orden ascendente por fecha
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "fecha"));

        // Obtener una página de tópicos con status = true
        Page<Topicos> topicosPage = topicosRepository.findByStatusTrue(pageRequest);

        // Mapear la página de entidades a una página de DTOs
        Page<DatosRespuestaTopicos> dtoPage = topicosPage.map(topico -> new DatosRespuestaTopicos(topico.getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getFecha(), topico.getAutor(), topico.getCurso(), topico.getStatus()));

        // Devolver la respuesta con la página de tópicos

        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopicos> retornaDatosTopicos(@PathVariable Long id){
        Topicos topicos = topicosRepository.getReferenceById(id);
        var datosTopicos = new DatosRespuestaTopicos(topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensaje(),
                topicos.getFecha(),
                topicos.getAutor(),
                topicos.getCurso(),
                topicos.getStatus());
        return ResponseEntity.ok(datosTopicos);

        }
    @PutMapping
    @Transactional// Indica que el método debe ejecutarse dentro de una transacción
    public ResponseEntity actualizarTopicos(@RequestBody @Valid DatosActualizarTopicos datosActualizarTopicos){
        Topicos topicos = topicosRepository.getReferenceById(datosActualizarTopicos.id());
        topicos.actualizarDatos(datosActualizarTopicos);

        return ResponseEntity.ok(new DatosRespuestaTopicos(topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensaje(),
                topicos.getFecha(),
                topicos.getAutor(),
                topicos.getCurso(),
                topicos.getStatus()));

    }
    @DeleteMapping("/{id}")
    @Transactional// Indica que el método debe ejecutarse dentro de una transacción
    public ResponseEntity eliminarTopico(@PathVariable Long id){
    Topicos topico = topicosRepository.getReferenceById(id);
    topico.desactivarTopico();
    return ResponseEntity.noContent().build();
    }

    }


