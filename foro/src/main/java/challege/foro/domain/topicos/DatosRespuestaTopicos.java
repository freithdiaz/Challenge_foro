package challege.foro.domain.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopicos(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fecha,
    String autor,
    String curso,

    Boolean status) {
}
