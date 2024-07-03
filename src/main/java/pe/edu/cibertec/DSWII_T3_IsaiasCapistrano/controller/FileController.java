package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.dto.ArchivoDto;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service.FileService;


import java.util.List;
@PreAuthorize("hasRole('Gestor')")
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/files")
public class FileController {

    private final FileService fileService;

    @Value("${file.upload.max-size-mb}")
    private int maxFileSizeMb;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/filesimages")
    public ResponseEntity<ArchivoDto> subirArchivos(
            @RequestParam("files") List<MultipartFile> multipartFileList
    ) {
        try {
            fileService.validarExtensiones(multipartFileList); //
            fileService.guardarArchivos(multipartFileList);
            return ResponseEntity.ok().body(ArchivoDto.builder()
                    .mensaje("Archivos subidos correctamente")
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ArchivoDto.builder()
                            .mensaje("Error al subir los archivos: " + e.getMessage())
                            .build());
        }
    }
}
