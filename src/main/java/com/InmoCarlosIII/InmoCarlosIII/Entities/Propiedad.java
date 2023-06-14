package com.InmoCarlosIII.InmoCarlosIII.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "propiedades")
public class Propiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column
    private String provincia;
    @Column
    private String municipio;
    @Column
    private String direccion;
    @Column
    private Double precio;
    @Column
    private String tipo;
    @Column
    private String habitaciones;
    @Column
    private String banyos;
    @Column
    private String superficie;
    @Column
    private String estado;
    @ElementCollection
    @CollectionTable(name = "propiedad_imagenes")
    @Column(name = "imagenes")
    private List<String> imagenes;
    @Column
    private String descripcion;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Usuario usuario;

    @OneToOne(mappedBy = "propiedad")
    private  Contrato contrato;

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }
}
