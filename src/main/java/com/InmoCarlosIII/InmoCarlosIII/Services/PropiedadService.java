package com.InmoCarlosIII.InmoCarlosIII.Services;

import com.InmoCarlosIII.InmoCarlosIII.Dto.PropiedadDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Propiedad;
import com.InmoCarlosIII.InmoCarlosIII.Mapper.PropiedadMapper;
import com.InmoCarlosIII.InmoCarlosIII.Repositories.PropiedadRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    @Autowired
    private PropiedadMapper propiedadMapper;
    private final Faker faker = new Faker();


    public PropiedadDTO createPropiedad(PropiedadDTO propiedadDTO) {
        Propiedad propiedad = propiedadMapper.toEntity(propiedadDTO);
        Propiedad savedPropiedad = propiedadRepository.save(propiedad);
        return propiedadMapper.toDTO(savedPropiedad);
    }

    public List<PropiedadDTO> getAllPropiedades() {
        return propiedadRepository.findAll().stream()
                .map(propiedadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PropiedadDTO> getPropiedadesByMunicipio(String municipio) {
        List<Propiedad> propiedadesByMunicipio = propiedadRepository.findAll()
                .stream()
                .filter(propiedad -> propiedad.getMunicipio().equalsIgnoreCase(municipio))
                .collect(Collectors.toList());

        return propiedadesByMunicipio.stream()
                .map(propiedadMapper::toDTO)
                .collect(Collectors.toList());
    }
    public List<PropiedadDTO> getPropiedadesByHabitaciones(int habitaciones) {
        List<Propiedad> propiedadesByHabitaciones = propiedadRepository.findAll()
                .stream()
                .filter(propiedad -> propiedad.getHabitaciones() == habitaciones)
                .collect(Collectors.toList());

        return propiedadesByHabitaciones.stream()
                .map(propiedadMapper::toDTO)
                .collect(Collectors.toList());
    }


    public PropiedadDTO getPropiedadById(Long id) {
        Optional<Propiedad> optionalPropiedad = propiedadRepository.findById(id);
        return optionalPropiedad.map(propiedadMapper::toDTO).orElse(null);
    }

    public PropiedadDTO updatePropiedad(PropiedadDTO propiedadDTO) {
        Optional<Propiedad> optionalPropiedad = propiedadRepository.findById(propiedadDTO.getId());

        if (!optionalPropiedad.isPresent()) {
            return null;
        }

        Propiedad propiedad = propiedadMapper.toEntity(propiedadDTO);
        Propiedad updatedPropiedad = propiedadRepository.save(propiedad);
        return propiedadMapper.toDTO(updatedPropiedad);
    }
    public void deletePropiedad(Long id) {
        propiedadRepository.deleteById(id);
    }

    public void generarDatosFicticios(int cantidad) {
        List<PropiedadDTO> propiedadesFicticias = new ArrayList<>();

        Faker faker = new Faker();

        for (int i = 0; i < cantidad; i++) {
            PropiedadDTO propiedad = new PropiedadDTO();
            propiedad.setProvincia(faker.address().state());
            propiedad.setMunicipio(faker.address().city());
            propiedad.setDireccion(faker.address().streetAddress());
            propiedad.setPrecio(Math.round(faker.number().numberBetween(100000, 1000000) / 1000)* 1000);
            propiedad.setTipo(faker.options().option("Piso", "Apartamento", "Chalet", "Dúplex"));
            propiedad.setHabitaciones(faker.number().numberBetween(1, 6));
            propiedad.setBanyos(faker.number().numberBetween(1, 4));
            propiedad.setSuperficie(faker.number().numberBetween(50, 200));
            propiedad.setEstado(faker.lorem().word());

            // Generar URLs ficticias de imágenes
            List<String> imagenes = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String imageUrl = "https://via.placeholder.com/500x500"; // URL ficticia de imagen
                imagenes.add(imageUrl);
            }

            propiedad.setImagenes(imagenes);

            propiedad.setDescripcion(faker.lorem().paragraph());

            propiedadesFicticias.add(propiedad);
        }

        List<Propiedad> propiedadesGuardadas = propiedadRepository.saveAll(propiedadMapper.toEntities(propiedadesFicticias));
        // Puedes realizar otras operaciones con las propiedades guardadas, si es necesario
    }



}
