package utn.dacs.ms.backend.model.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSponsor;
    private String nombre;
    private String logo;
    private String nivelSponsor;
}
