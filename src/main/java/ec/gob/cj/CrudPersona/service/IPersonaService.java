package ec.gob.cj.CrudPersona.service;

import java.util.List;

/**
 * @author saira
 */
public interface IPersonaService {
    List<PersonaDto> obtener();
    PersonaDto crear(PersonaDto producto);
    PersonaDto actualizar(Long id, PersonaDto producto);
    void eliminar(Long id);
    public Map<String, Object> consultarPorCedula(String cedula);
}
