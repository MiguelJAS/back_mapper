package com.InmoCarlosIII.InmoCarlosIII.Services;

import com.InmoCarlosIII.InmoCarlosIII.Dto.ContratoDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Contrato;
import com.InmoCarlosIII.InmoCarlosIII.Mapper.ContratoMapper;
import com.InmoCarlosIII.InmoCarlosIII.Repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ContratoMapper contratoMapper;

    public ContratoDTO createContrato(ContratoDTO contratoDTO) {
        Contrato contrato = contratoMapper.toEntity(contratoDTO);
        Contrato savedContrato = contratoRepository.save(contrato);
        return contratoMapper.toDTO(savedContrato);
    }

    public List<ContratoDTO> getAllContratos() {
        return contratoRepository.findAll().stream()
                .map(contratoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContratoDTO getContratoById(Long id) {
        Optional<Contrato> optionalContrato = contratoRepository.findById(id);
        return optionalContrato.map(contratoMapper::toDTO).orElse(null);
    }

    public ContratoDTO updateContrato(ContratoDTO contratoDTO) {
        Optional<Contrato> optionalContrato = contratoRepository.findById(contratoDTO.getId());

        if (!optionalContrato.isPresent()) {
            return null;
        }

        Contrato contrato = contratoMapper.toEntity(contratoDTO);
        Contrato updatedContrato = contratoRepository.save(contrato);
        return contratoMapper.toDTO(updatedContrato);
    }

    public void deleteContrato(Long id) {
        contratoRepository.deleteById(id);
    }
}
