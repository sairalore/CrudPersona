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
public class FuncionarioDto {
    private Long id;
    private String cargo;
    private Double salario;
    private Long idPersona;
}
