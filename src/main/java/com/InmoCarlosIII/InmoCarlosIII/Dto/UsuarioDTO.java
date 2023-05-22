package com.InmoCarlosIII.InmoCarlosIII.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nombre")
    @NotNull
    private String nombre;

    @NotNull
    @Column(name = "clave", nullable = false)
    private String clave;

    @JsonProperty("email")
    @NotNull
    private String email;


    @JsonProperty("telefono")
    @NotNull
    private String telefono;



}
