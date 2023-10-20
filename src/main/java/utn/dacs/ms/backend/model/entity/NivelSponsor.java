package utn.dacs.ms.backend.model.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "nivel_sponsor")
public class NivelSponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_sponsor")
    private Long idNivelSponsor;
    private String nombre;


}
