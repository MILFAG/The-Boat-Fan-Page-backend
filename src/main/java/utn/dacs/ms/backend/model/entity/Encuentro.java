package utn.dacs.ms.backend.model.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Encuentro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEncuentro;
    private Date fecha;
    private String rival;
    private String imagenRival;

  /*  @ManyToMany
    @JoinTable(
            name = "jugador_juega_encuentro",
            joinColumns = @JoinColumn(name = "idJugador"),
            inverseJoinColumns = @JoinColumn(name = "idEncuentro")
    )
    private List<Jugador> jugadores;*/
}
