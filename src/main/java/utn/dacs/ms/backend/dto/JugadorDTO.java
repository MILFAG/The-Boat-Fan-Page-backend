package utn.dacs.ms.backend.dto;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class JugadorDTO {
    private Long id;
    private String usuario;
    private String tag;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nombreAgente;

}
