package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {

    void guardarArchivo(MultipartFile archivo) throws Exception;

    void guardarArchivos(List<MultipartFile> archivosList) throws Exception;

    void validarExtensiones(List<MultipartFile> archivosList) throws Exception;
}