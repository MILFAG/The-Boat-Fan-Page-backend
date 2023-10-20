package utn.dacs.ms.backend.dto;
import lombok.Data;
import utn.dacs.ms.backend.model.entity.Jugador;
import java.util.Date;
import java.util.List;
@Data
public class PartidaDTO {
    private Long id;
    private Date fecha;
    private List<JugadorDTO> jugadores;
}
