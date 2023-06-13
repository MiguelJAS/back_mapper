package com.InmoCarlosIII.InmoCarlosIII.Controllers;

import com.InmoCarlosIII.InmoCarlosIII.Dto.ContratoDTO;
import com.InmoCarlosIII.InmoCarlosIII.Services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity<ContratoDTO> createContrato(@RequestBody ContratoDTO contratoDTO) {
        ContratoDTO createdContrato = contratoService.createContrato(contratoDTO);
        return ResponseEntity.ok(createdContrato);
    }

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> getAllContratos() {
        List<ContratoDTO> contratos = contratoService.getAllContratos();
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> getContratoById(@PathVariable Long id) {
        ContratoDTO contrato = contratoService.getContratoById(id);
        if (contrato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contrato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> updateContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        contratoDTO.setId(id);
        ContratoDTO updatedContrato = contratoService.updateContrato(contratoDTO);
        if (updatedContrato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedContrato);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable Long id) {
        try {
            contratoService.deleteContrato(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
