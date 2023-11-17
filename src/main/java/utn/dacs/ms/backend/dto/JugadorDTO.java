package utn.dacs.ms.backend.dto;
import lombok.Data;

import java.util.Date;

@Data
public class JugadorDTO {
    private Long id;
    private String usuario;
    private String tag;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nombreAgente;

}
