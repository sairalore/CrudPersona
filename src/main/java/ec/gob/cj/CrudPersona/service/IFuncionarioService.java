package ec.gob.cj.CrudPersona.service;

import ec.gob.cj.CrudPersona.dto.FuncionarioDto;
import ec.gob.cj.CrudPersona.dto.PersonaDto;

import java.util.List;

/**
 * @author saira
 */
public interface IFuncionarioService {
    List<FuncionarioDto> obtener();
    FuncionarioDto crear(FuncionarioDto dto);
    FuncionarioDto actualizar(Long id, FuncionarioDto dto);
    void eliminar(Long id);
}
