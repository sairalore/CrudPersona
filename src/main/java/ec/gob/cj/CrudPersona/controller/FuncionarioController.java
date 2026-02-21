package ec.gob.cj.CrudPersona.controller;

import ec.gob.cj.CrudPersona.dto.FuncionarioDto;
import ec.gob.cj.CrudPersona.service.IFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * @author saira
 */
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    @Autowired
    private IFuncionarioService iFuncionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDto>> obtener() {
        return ResponseEntity.ok(iFuncionarioService.obtener());
    }

    @PostMapping
    public ResponseEntity<FuncionarioDto> crear(@RequestBody FuncionarioDto dto) {
        FuncionarioDto funcionarioDto = iFuncionarioService.crear(dto);
        return ResponseEntity.created(URI.create("/api/personas" + funcionarioDto.getId())).body(funcionarioDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDto> actualizar(@PathVariable Long id,
                                                     @RequestBody FuncionarioDto dto) {
        return ResponseEntity.ok(iFuncionarioService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        iFuncionarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
