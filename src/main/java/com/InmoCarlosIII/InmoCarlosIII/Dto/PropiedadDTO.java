package com.InmoCarlosIII.InmoCarlosIII.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadDTO {

    private Long id;

    private String provincia;

    private String municipio;

    private String direccion;

    private Double precio;

    private String tipo;

    private String habitaciones;

    private String banyos;

    private String superficie;

    private String estado;

    private String imagenes;

    private String descripcion;

}
