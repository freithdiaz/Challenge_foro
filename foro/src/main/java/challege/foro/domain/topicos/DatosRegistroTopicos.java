package challege.foro.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopicos(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        LocalDateTime fecha,
        @NotBlank
        String autor,
        @NotBlank
        String curso,
        boolean status
) {
}
