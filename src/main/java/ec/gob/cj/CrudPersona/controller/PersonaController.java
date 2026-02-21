package ec.gob.cj.CrudPersona.controller;

import ec.gob.cj.CrudPersona.dto.PersonaDto;
import ec.gob.cj.CrudPersona.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * @author saira
 */
@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    IPersonaService iPersonaService;

    @GetMapping
    public ResponseEntity<List<PersonaDto>> obtener() {
        return ResponseEntity.ok(iPersonaService.obtener());
    }

    @PostMapping
    public ResponseEntity<PersonaDto> crear(@RequestBody PersonaDto dto) {
        PersonaDto personaDto = iPersonaService.crear(dto);
        return ResponseEntity.created(URI.create("/api/personas" + personaDto.getId())).body(personaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDto> actualizar(@PathVariable Long id,
                                                 @RequestBody PersonaDto dto) {
        return ResponseEntity.ok(iPersonaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        iPersonaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
