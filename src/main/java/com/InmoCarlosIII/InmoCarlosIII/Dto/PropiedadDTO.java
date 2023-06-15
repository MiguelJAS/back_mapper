package com.InmoCarlosIII.InmoCarlosIII.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadDTO {

    private Long id;

    private String provincia;

    private String municipio;

    private String direccion;

    private int precio;

    private String tipo;

    private int habitaciones;

    private int banyos;

    private int superficie;

    private String estado;

    private List<String> imagenes;

    private String descripcion;

}
