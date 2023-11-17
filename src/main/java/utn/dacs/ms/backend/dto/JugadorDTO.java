package utn.dacs.ms.backend.dto;
import lombok.Data;
@Data
public class JugadorDTO {
    private Long id;
    private String usuario;
    private String tag;
    private String nombre;
    private int edad;
    private String nombreAgente;

}
