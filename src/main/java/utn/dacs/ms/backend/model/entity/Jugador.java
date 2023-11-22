package utn.dacs.ms.backend.model.entity;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJugador;
    private String usuario;
    private String tag;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String  nombreAgente;

}
