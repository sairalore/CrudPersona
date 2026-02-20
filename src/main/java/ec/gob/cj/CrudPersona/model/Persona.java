package ec.gob.cj.CrudPersona.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * @author saira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
}
