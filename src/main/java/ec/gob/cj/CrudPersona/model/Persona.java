package ec.gob.cj.CrudPersona.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author saira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cedula;
    private String nombre;
    private String email;
}
