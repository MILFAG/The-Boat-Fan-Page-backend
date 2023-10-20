package utn.dacs.ms.backend.dto;
import lombok.Data;
import utn.dacs.ms.backend.model.entity.NivelSponsor;

@Data
public class SponsorDTO {
    private Long id;
    private String nombre;
    private String logo;
    private NivelSponsor nivel;
}
