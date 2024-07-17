package challege.foro.domain.topicos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopicos(@NotNull Long id,
                                     String titulo,
                                     String mensaje,
                                     LocalDateTime fecha,
                                     String autor,
                                     String curso,
                                     Boolean status) {
}
