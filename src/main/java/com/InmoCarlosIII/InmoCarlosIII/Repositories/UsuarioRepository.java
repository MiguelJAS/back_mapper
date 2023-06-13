package com.InmoCarlosIII.InmoCarlosIII.Repositories;

import com.InmoCarlosIII.InmoCarlosIII.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findOneByUsuario(String usuario);

}
