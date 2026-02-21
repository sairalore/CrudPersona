package ec.gob.cj.CrudPersona.exception;

/**
 * @author saira
 */
public class PersonaNotFoundException extends RuntimeException{
    public PersonaNotFoundException(String message) {
        super(message);
    }
}
