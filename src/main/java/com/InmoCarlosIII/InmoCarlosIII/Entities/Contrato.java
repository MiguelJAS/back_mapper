package com.InmoCarlosIII.InmoCarlosIII.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column
    private String tipo;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaFin;
    @Column
    private String precio;
    @Column
    private String detalles;
}
