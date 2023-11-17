package utn.dacs.ms.backend.model.entity;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJugador;
    private String usuario;
    private String tag;
    private String nombre;
    private int edad;
    private String  nombreAgente;

}
