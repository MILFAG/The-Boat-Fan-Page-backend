package utn.dacs.ms.backend.dto;
import lombok.Data;
import utn.dacs.ms.backend.model.entity.Jugador;
import java.util.List;

@Data
public class FanDTO {
    private Long id;
    private String nombre;
    private String correo;
    private List<JugadorDTO> favoritos;
}
