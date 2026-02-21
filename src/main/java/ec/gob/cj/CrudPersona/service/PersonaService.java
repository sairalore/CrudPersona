package ec.gob.cj.CrudPersona.service;

import ec.gob.cj.CrudPersona.dto.PersonaDto;
import ec.gob.cj.CrudPersona.exception.PersonaNotFoundException;
import ec.gob.cj.CrudPersona.mapper.Mapper;
import ec.gob.cj.CrudPersona.model.Persona;
import ec.gob.cj.CrudPersona.repository.FuncionarioRepository;
import ec.gob.cj.CrudPersona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saira
 */

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<PersonaDto> obtener() {
        return personaRepository.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public PersonaDto crear(PersonaDto dto) {
        //validaciones
        if(dto == null) throw new RuntimeException("PersonaDto no puede ser null");

        Persona per = Persona.builder()
                .cedula(dto.getCedula())
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .build();
        return Mapper.toDto(personaRepository.save(per));
    }

    @Override
    public PersonaDto actualizar(Long id, PersonaDto dto) {
        Persona per = personaRepository.findById(id).orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada"));
        per.setNombre(dto.getNombre());
        per.setCedula(dto.getCedula());
        per.setEmail(dto.getEmail());
        return Mapper.toDto(personaRepository.save(per));
    }

    @Override
    public void eliminar(Long id) {
        if (!personaRepository.existsById(id)) {
            throw new PersonaNotFoundException("Persona no encontrada para eliminar");
        }
        personaRepository.deleteById(id);
    }


    public PersonaDto obtenerPersonaPorCedula(String cedula) {
        Persona persona = personaRepository.findByCedula(cedula)
                .orElseThrow(() -> new PersonaNotFoundException("Persona identificada con: " + cedula + "no encontrada"));
        boolean esFuncionario = funcionarioRepository.existsByPersonaCedula(cedula);
        return new PersonaDto(
                persona.getId(),
                persona.getNombre(),
                persona.getCedula(),
                persona.getEmail(),
                esFuncionario
        );
    }
}
