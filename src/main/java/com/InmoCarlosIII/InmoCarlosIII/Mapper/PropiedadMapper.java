package com.InmoCarlosIII.InmoCarlosIII.Mapper;

import com.InmoCarlosIII.InmoCarlosIII.Dto.PropiedadDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Propiedad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PropiedadMapper {
    Propiedad toEntity(PropiedadDTO propiedadDTO);

    PropiedadDTO toDTO(Propiedad propiedad);

}
