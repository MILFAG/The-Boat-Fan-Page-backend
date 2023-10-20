package utn.dacs.ms.backend.model.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartida;
    private Date fecha;
    @ManyToMany
    @JoinTable(
            name = "jugador_juega_partida",
            joinColumns = @JoinColumn(name = "idJugador"),
            inverseJoinColumns = @JoinColumn(name = "idPartida")
    )
    private List<Jugador> jugadores;
}
