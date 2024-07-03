package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Publicacion;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.dto.PublicacionDto;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service.IPublicacionService;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/pubs-dto")
public class PublicacionController {

    private IPublicacionService publicacionService;
    private DtoUtil dtoUtil;

    @GetMapping("")
    public ResponseEntity<List<PublicacionDto>> listarPublicacionesDto() {
        List<Publicacion> publicaciones = publicacionService.listarPublicaciones();
        List<PublicacionDto> publicacionesDto = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            PublicacionDto dto = dtoUtil.convertirADto(publicacion, new PublicacionDto());
            if (publicacion.getAutor() != null) {
                dto.setFecha(publicacion.getFechpublicacion());
                dto.setNomautor(publicacion.getAutor().getNomautor());
                dto.setApeautor(publicacion.getAutor().getApeautor());
            }
            publicacionesDto.add(dto);
        }

        if (publicacionesDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(publicacionesDto, HttpStatus.OK);
    }
}
