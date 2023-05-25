package com.InmoCarlosIII.InmoCarlosIII.Controllers;

import com.InmoCarlosIII.InmoCarlosIII.Dto.PropiedadDTO;
import com.InmoCarlosIII.InmoCarlosIII.Services.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    @PostMapping
    public ResponseEntity<PropiedadDTO> createPropiedad(@RequestBody PropiedadDTO propiedadDTO) {
        PropiedadDTO createdPropiedad = propiedadService.createPropiedad(propiedadDTO);
        return ResponseEntity.ok(createdPropiedad);
    }

    @GetMapping
    public ResponseEntity<List<PropiedadDTO>> getAllPropiedades() {
        List<PropiedadDTO> propiedades = propiedadService.getAllPropiedades();
        return ResponseEntity.ok(propiedades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropiedadDTO> getPropiedadById(@PathVariable Long id) {
        PropiedadDTO propiedad = propiedadService.getPropiedadById(id);
        if (propiedad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(propiedad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropiedadDTO> updatePropiedad(@PathVariable Long id, @RequestBody PropiedadDTO propiedadDTO) {
        propiedadDTO.setId(id);
        PropiedadDTO updatedPropiedad = propiedadService.updatePropiedad(propiedadDTO);
        if (updatedPropiedad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPropiedad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropiedad(@PathVariable Long id) {
        propiedadService.deletePropiedad(id);
        return ResponseEntity.ok().build();
    }
}
