package com.InmoCarlosIII.InmoCarlosIII.Dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nombre;

    private String apellidos;

    private String usuario;

    private String clave;

    private String email;

    private String telefono;

    private boolean admin;
}
