package com.InmoCarlosIII.InmoCarlosIII.Mapper;

import com.InmoCarlosIII.InmoCarlosIII.Dto.UsuarioDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario  toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);
}
