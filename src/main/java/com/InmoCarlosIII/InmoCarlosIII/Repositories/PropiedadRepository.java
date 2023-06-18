package com.InmoCarlosIII.InmoCarlosIII.Repositories;

import java.util.List;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Contrato;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
}
