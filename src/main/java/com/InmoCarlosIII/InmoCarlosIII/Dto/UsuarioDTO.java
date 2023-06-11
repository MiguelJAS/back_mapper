package com.InmoCarlosIII.InmoCarlosIII.Dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nombre;

    private String apellidos;

    private String clave;

    private String email;

    private String telefono;
}
