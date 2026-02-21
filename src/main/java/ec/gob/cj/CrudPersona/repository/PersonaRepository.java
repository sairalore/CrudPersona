package ec.gob.cj.CrudPersona.repository;

import ec.gob.cj.CrudPersona.model.Funcionario;
import ec.gob.cj.CrudPersona.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * @author saira
 */

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByCedula(String cedula);
}
