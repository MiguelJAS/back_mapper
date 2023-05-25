package com.InmoCarlosIII.InmoCarlosIII.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {

    private Long id;

    private String tipo;

    private Date fechaInicio;

    private Date fechaFin;

    private String precio;

    private String detalles;
}
