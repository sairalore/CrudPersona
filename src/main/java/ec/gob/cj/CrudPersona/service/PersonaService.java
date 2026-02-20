package ec.gob.cj.CrudPersona.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saira
 */
@Service
public class PersonaService implements IPersonaService{
    @Override
    public List<PersonaDto> obtener() {
        return List.of();
    }

    @Override
    public PersonaDto crear(PersonaDto producto) {
        return null;
    }

    @Override
    public PersonaDto actualizar(Long id, PersonaDto producto) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Map<String, Object> consultarPorCedula(String cedula) {
        return null;
    }
}
