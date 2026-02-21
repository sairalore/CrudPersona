package ec.gob.cj.CrudPersona.mapper;

import ec.gob.cj.CrudPersona.dto.PersonaDto;
import ec.gob.cj.CrudPersona.model.Funcionario;
import ec.gob.cj.CrudPersona.model.Persona;

/**
 * @author saira
 */
public class Mapper {
    public static PersonaDto toDto(Persona persona) {
        if (persona == null) return null;
        return PersonaDto.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .cedula(persona.getCedula())
                .esFuncionario(Boolean.FALSE)
                .build();
    }

}
