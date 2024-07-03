package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Autor;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.dto.AutorDto;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service.IAutorService;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.util.DtoUtil;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.dto.DtoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PreAuthorize("hasRole('Coordinador')")
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/autor")
public class AutorController {

    private IAutorService autorService;

    @GetMapping("")
    public ResponseEntity<List<Autor>> listarAutores() {
        List<Autor> autorList = new ArrayList<>(autorService.listarAutores());
        if (autorList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(autorList, HttpStatus.OK);
    }

    @GetMapping("/pubs-dto")
    public ResponseEntity<List<DtoEntity>> listarAutoresDto() {
        List<DtoEntity> autorDtoList = autorService.listarAutores()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x, new AutorDto()))
                .collect(Collectors.toList());
        if (autorDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(autorDtoList, HttpStatus.OK);
    }
    @GetMapping("pubs-dto/{id}")
    public ResponseEntity<Autor> obtenerAutorXId(@PathVariable Integer id) {
        Autor autor = autorService.obtenerAutorxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El autor con ID " + id + " no existe"));
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }
}
