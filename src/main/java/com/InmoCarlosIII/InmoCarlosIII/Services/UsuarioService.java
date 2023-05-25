package com.InmoCarlosIII.InmoCarlosIII.Services;

import com.InmoCarlosIII.InmoCarlosIII.Dto.UsuarioDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Usuario;
import com.InmoCarlosIII.InmoCarlosIII.Mapper.UsuarioMapper;
import com.InmoCarlosIII.InmoCarlosIII.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(savedUsuario);
    }

    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Long id) {
        return usuarioMapper.toDTO(usuarioRepository.findById(id).orElse(null));
    }

    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioDTO.getId());

        if (!optionalUsuario.isPresent()) {
            return null;
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(updatedUsuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
