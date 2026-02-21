package ec.gob.cj.CrudPersona.dto;

import lombok.*;

/**
 * @author saira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaDto {
    private Long id;
    private String nombre;
    private String cedula;
    private String email;
    private Boolean esFuncionario;

}
