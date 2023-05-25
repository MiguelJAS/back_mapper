package com.InmoCarlosIII.InmoCarlosIII.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    @Column(name = "nombre", nullable = false)
    private  String nombre;
    @NotNull
    @Email
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull
    @Column(name = "clave", nullable = false)
    private String clave;
    @NotNull
    @Column(name = "telefono", nullable = false)
    private String telefono;


}