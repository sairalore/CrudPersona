package ec.gob.cj.CrudPersona.repository;

import ec.gob.cj.CrudPersona.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author saira
 */

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByPersonaCedula(String cedula);
    ///Optional<Funcionario> findByPersonaCedula(String cedula);
}
