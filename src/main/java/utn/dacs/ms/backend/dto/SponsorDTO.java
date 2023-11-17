package utn.dacs.ms.backend.dto;
import lombok.Data;

@Data
public class SponsorDTO {
    private Long id;
    private String nombre;
    private String logo;
    private String nivelSponsor;
}
