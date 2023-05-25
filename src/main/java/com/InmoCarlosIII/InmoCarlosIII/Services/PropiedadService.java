package com.InmoCarlosIII.InmoCarlosIII.Services;

import com.InmoCarlosIII.InmoCarlosIII.Dto.PropiedadDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Propiedad;
import com.InmoCarlosIII.InmoCarlosIII.Mapper.PropiedadMapper;
import com.InmoCarlosIII.InmoCarlosIII.Repositories.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    @Autowired
    private PropiedadMapper propiedadMapper;

    public PropiedadDTO createPropiedad(PropiedadDTO propiedadDTO) {
        Propiedad propiedad = propiedadMapper.toEntity(propiedadDTO);
        Propiedad savedPropiedad = propiedadRepository.save(propiedad);
        return propiedadMapper.toDTO(savedPropiedad);
    }

    public List<PropiedadDTO> getAllPropiedades() {
        return propiedadRepository.findAll().stream()
                .map(propiedadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PropiedadDTO getPropiedadById(Long id) {
        Optional<Propiedad> optionalPropiedad = propiedadRepository.findById(id);
        return optionalPropiedad.map(propiedadMapper::toDTO).orElse(null);
    }

    public PropiedadDTO updatePropiedad(PropiedadDTO propiedadDTO) {
        Optional<Propiedad> optionalPropiedad = propiedadRepository.findById(propiedadDTO.getId());

        if (!optionalPropiedad.isPresent()) {
            return null;
        }

        Propiedad propiedad = propiedadMapper.toEntity(propiedadDTO);
        Propiedad updatedPropiedad = propiedadRepository.save(propiedad);
        return propiedadMapper.toDTO(updatedPropiedad);
    }

    public void deletePropiedad(Long id) {
        propiedadRepository.deleteById(id);
    }
}
