package ec.gob.cj.CrudPersona.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author saira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cargo;
    private Double salario;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;
}
