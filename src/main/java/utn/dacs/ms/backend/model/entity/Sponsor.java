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
    @ManyToOne
    @JoinColumn(name = "nivel_sponsor", referencedColumnName = "id_nivel_sponsor")
    private NivelSponsor nivel;
}
