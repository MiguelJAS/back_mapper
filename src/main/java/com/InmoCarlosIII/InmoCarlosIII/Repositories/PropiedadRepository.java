package com.InmoCarlosIII.InmoCarlosIII.Repositories;

import com.InmoCarlosIII.InmoCarlosIII.Entities.Contrato;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
}
