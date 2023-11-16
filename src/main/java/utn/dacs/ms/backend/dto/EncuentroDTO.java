package utn.dacs.ms.backend.dto;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class EncuentroDTO {
    private Long id;
    private Date fecha;
    private List<JugadorDTO> jugadores;
}
