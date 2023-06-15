package com.InmoCarlosIII.InmoCarlosIII.Services;

import com.InmoCarlosIII.InmoCarlosIII.Dto.PropiedadDTO;
import com.InmoCarlosIII.InmoCarlosIII.Entities.Propiedad;
import com.InmoCarlosIII.InmoCarlosIII.Mapper.PropiedadMapper;
import com.InmoCarlosIII.InmoCarlosIII.Repositories.PropiedadRepository;
import com.github.javafaker.Faker;
import java.util.Locale;
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

    int contador = 0;
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

        Faker faker = new Faker(new Locale("es"));

        for (int i = 0; i < cantidad; i++) {
            PropiedadDTO propiedad = new PropiedadDTO();
            propiedad.setProvincia(faker.address().state());
            propiedad.setMunicipio(faker.address().city());
            propiedad.setDireccion(faker.address().streetAddress());
            propiedad.setPrecio(Math.round(faker.number().numberBetween(100000, 1000000) / 1000)* 1000);
            propiedad.setTipo(faker.options().option("Piso", "Apartamento", "Chalet", "Dúplex"));
            propiedad.setHabitaciones(faker.number().numberBetween(1, 6));
            propiedad.setBanyos(faker.number().numberBetween(1, 4));
            propiedad.setSuperficie(faker.number().numberBetween(50, 300));
            propiedad.setEstado(faker.lorem().word());

            // Generar URLs ficticias de imágenes
            List<String> imagenes = new ArrayList<>();
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130355/34238828/594038172.jpg?rule=web_948x542");
            imagenes.add("https://static.fotocasa.es/images/anuncio/2023/06/15/178198529/3161427643.jpg?rule=web_482x269");
            imagenes.add("https://static.fotocasa.es/images/anuncio/2023/06/15/178198529/3161427661.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33569767/565638550.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130355/34238828/594038174.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130355/34238828/594038176.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/102570/33914716/579001001.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/102570/33914716/579001020.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/102570/33914716/579000884.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/108152/33393029/572180786.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/102570/33914716/579001020.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/102570/33914716/579000884.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/108152/33393029/572180786.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/108152/33393029/572180787.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/108152/33393029/572180788.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85490/33837598/576360515.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85490/33837598/576360530.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85490/33837598/576360514.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/30468392/471451366.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/30468392/471451367.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/30468392/471451368.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33719014/571091196.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33719014/571091197.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33719014/571091198.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93159/33671291/592329942.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93159/33671291/592329943.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93159/33671291/592329944.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/90800/31930806/512982797.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/90800/31930806/512982798.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/90800/31930806/512982799.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/94820/34170440/591243864.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/94820/34170440/591243865.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/94820/34170440/591243866.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33962308/580216221.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33962308/580216222.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33962308/580216223.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33729437/571520545.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33729437/571520546.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33729437/571520548.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130213/33620938/567326253.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130213/33620938/567326254.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130213/33620938/567326255.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33565487/565488267.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33565487/565488270.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/33565487/565488273.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131223/34191667/590910396.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131223/34191667/590910395.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131223/34191667/590910397.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/28737770/444861543.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/28737770/444861544.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/123340/28737770/444861545.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85842/34176139/590386125.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85842/34176139/590386128.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85842/34176139/590386127.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93022/32549658/530633020.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93022/32549658/530633021.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93022/32549658/530633022.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/105343/32013485/515390469.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/105343/32013485/515390428.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/105343/32013485/515390430.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85842/30520701/472761546.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85842/30520701/472761457.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/85842/30520701/472761929.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86679/34250081/593539017.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86679/34250081/593539007.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86679/34250081/593539009.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/110665/33631640/577808940.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/110665/33631640/577808941.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/110665/33631640/577808942.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/132301/33826946/576164403.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/132301/33826946/576164404.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/132301/33826946/576164405.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/107974/34068058/584392473.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/107974/34068058/584392464.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/107974/34068058/584392460.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/109002/34245135/593318399.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/109002/34245135/593318400.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/109002/34245135/593318401.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/87582/29661549/448357753.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/87582/29661549/448357737.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/87582/29661549/448357735.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86679/34250133/593543323.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86679/34250133/593543325.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86679/34250133/593543326.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/111456/34245839/593346688.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/111456/34245839/593346665.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/111456/34245839/593346686.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/94501/34174969/590105152.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/94501/34174969/590105193.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/94501/34174969/590105113.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/95286/34193421/591060447.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/95286/34193421/591060448.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/95286/34193421/591060449.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/128578/34166653/589708292.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/128578/34166653/589708293.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/128578/34166653/589708294.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/105370/34007477/582005885.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/105370/34007477/582005886.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/105370/34007477/582005887.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131394/33767124/579215890.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131394/33767124/579215891.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131394/33767124/579215892.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/109002/34006311/584375363.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/109002/34006311/584375364.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/109002/34006311/584375365.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93013/34097041/586265832.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93013/34097041/586265833.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93013/34097041/586265834.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/97405/22184348/489404855.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/97405/22184348/489404858.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/97405/22184348/489404865.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131394/33775665/581109598.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131394/33775665/581109599.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/131394/33775665/581109600.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/97405/33916325/579056738.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/97405/33916325/579056756.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/97405/33916325/579056762.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93295/33856309/576989976.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93295/33856309/576989978.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/93295/33856309/576989977.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/117513/33869687/577316845.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/117513/33869687/577316838.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/117513/33869687/577316839.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/90134/33961973/580207650.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/90134/33961973/580207651.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/90134/33961973/580207652.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/89993/33287804/555594278.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/89993/33287804/555594280.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/89993/33287804/555594281.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130213/32432939/527476101.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130213/32432939/527476102.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/130213/32432939/527476103.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/138151/33985116/593378376.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/138151/33985116/593378395.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/138151/33985116/593378397.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86974/33814850/591137437.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86974/33814850/591137438.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/86974/33814850/591137439.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/92214/33929753/579342092.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/92214/33929753/579342095.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/92214/33929753/579342101.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/133452/33760342/590417512.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/133452/33760342/590417514.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/133452/33760342/590417517.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/134973/33511997/563840282.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/134973/33511997/563840378.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/134973/33511997/563839844.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/91223/34052226/590230613.jpg?rule=web_948x542");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/91223/34052226/590230614.jpg?rule=web_482x269");
            imagenes.add("https://static.inmofactory.com/images/inmofactory/documents/1/91223/34052226/590230615.jpg?rule=web_482x269");

            List<String> arrayImagenes = new ArrayList<>();
            for (i = contador; i < contador + 3; i++) {
                arrayImagenes.add(imagenes.get(i));
            }
            contador += 3;

            propiedad.setImagenes(arrayImagenes);

            propiedad.setDescripcion(faker.lorem().paragraph());

            propiedadesFicticias.add(propiedad);
        }

        List<Propiedad> propiedadesGuardadas = propiedadRepository.saveAll(propiedadMapper.toEntities(propiedadesFicticias));
        // Puedes realizar otras operaciones con las propiedades guardadas, si es necesario
    }



}
