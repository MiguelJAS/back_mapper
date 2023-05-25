package com.InmoCarlosIII.InmoCarlosIII.Mapper;

import com.InmoCarlosIII.InmoCarlosIII.Dto.ContratoDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Contrato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContratoMapper {
    Contrato toEntity(ContratoDTO contratoDTO);

    ContratoDTO toDTO(Contrato contrato);
}


