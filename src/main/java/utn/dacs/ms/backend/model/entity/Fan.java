package utn.dacs.ms.backend.model.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Fan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFan;
    private String correo;
    private String nombre;
    @ManyToMany
    @JoinTable(
            name = "jugador_favorito",
            joinColumns = @JoinColumn(name = "idJugador"),
            inverseJoinColumns = @JoinColumn(name = "idFan")
    )
    private List<Jugador> favoritos;
}

