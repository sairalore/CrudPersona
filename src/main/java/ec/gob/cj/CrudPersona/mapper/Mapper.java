package ec.gob.cj.CrudPersona.mapper;

import ec.gob.cj.CrudPersona.dto.FuncionarioDto;
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
                .email(persona.getEmail())
                .build();
    }

    public static FuncionarioDto toDto(Funcionario funcionario) {
        if (funcionario == null) return null;
        return FuncionarioDto.builder()
                .id(funcionario.getId())
                .cargo(funcionario.getCargo())
                .salario(funcionario.getSalario())
                .idPersona(funcionario.getPersona().getId())
                .build();
    }

}
