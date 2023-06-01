package com.InmoCarlosIII.InmoCarlosIII.Dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidos;
    @NotNull
    private String clave;

    @NotNull
    private String email;

    @NotNull
    private String telefono;



}
