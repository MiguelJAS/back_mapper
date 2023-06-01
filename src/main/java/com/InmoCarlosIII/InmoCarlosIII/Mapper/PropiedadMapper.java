package com.InmoCarlosIII.InmoCarlosIII.Mapper;

import com.InmoCarlosIII.InmoCarlosIII.Dto.PropiedadDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Propiedad;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PropiedadMapper {
    Propiedad toEntity(PropiedadDTO propiedadDTO);

    PropiedadDTO toDTO(Propiedad propiedad);

    //Para recibir la lista de datos ficticios
    List<Propiedad> toEntities(List<PropiedadDTO> propiedadDTOs);


}
