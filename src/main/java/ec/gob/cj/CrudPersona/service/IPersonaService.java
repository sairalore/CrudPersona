package ec.gob.cj.CrudPersona.service;

import ec.gob.cj.CrudPersona.dto.PersonaDto;

import java.util.List;
import java.util.Map;

/**
 * @author saira
 */
public interface IPersonaService {
    List<PersonaDto> obtener();
    PersonaDto crear(PersonaDto producto);
    PersonaDto actualizar(Long id, PersonaDto producto);
    void eliminar(Long id);
    PersonaDto obtenerPersonaPorCedula(String cedula);
}
