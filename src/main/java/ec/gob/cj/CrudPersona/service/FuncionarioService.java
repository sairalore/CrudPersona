package ec.gob.cj.CrudPersona.service;

import ec.gob.cj.CrudPersona.dto.FuncionarioDto;
import ec.gob.cj.CrudPersona.exception.PersonaNotFoundException;
import ec.gob.cj.CrudPersona.mapper.Mapper;
import ec.gob.cj.CrudPersona.model.Funcionario;
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
public class FuncionarioService implements IFuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public List<FuncionarioDto> obtener() {
        return funcionarioRepository.findAll().stream().map(Mapper::toDto).toList();

    }

    @Override
    public FuncionarioDto crear(FuncionarioDto dto) {
        //validaciones
        if (dto == null) throw new RuntimeException("FuncionarioDto no puede ser null");
        if (dto.getIdPersona() == null) throw new RuntimeException("Debe haber una persona");

        //Busco la persona
        Persona persona = personaRepository.findById(dto.getIdPersona()).orElse(null);
        if (persona == null) throw new PersonaNotFoundException("Persona no encontrada");

        //Crear el funcionario
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.getCargo());
        funcionario.setSalario(dto.getSalario());
        funcionario.setPersona(persona);
        return Mapper.toDto(funcionarioRepository.save(funcionario));
    }

    @Override
    public FuncionarioDto actualizar(Long id, FuncionarioDto dto) {
        //busco al funcionario a borrar
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException("Funcionario no encontrado"));
        if (dto.getCargo() != null) funcionario.setCargo(dto.getCargo());
        if (dto.getSalario() != null) funcionario.setSalario(dto.getSalario());
        if (dto.getIdPersona() != null) {
            Persona persona = personaRepository.findById(dto.getIdPersona()).orElse(null);
            if (persona == null) throw new PersonaNotFoundException("Persona no encontrada");
            funcionario.setPersona(persona);
        }

        return Mapper.toDto(funcionarioRepository.save(funcionario));
    }

    @Override
    public void eliminar(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new PersonaNotFoundException("Funciionario no encontrado para eliminar");
        }
        funcionarioRepository.deleteById(id);

    }
}
