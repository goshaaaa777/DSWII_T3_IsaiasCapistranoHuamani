package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service;

import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<Autor> listarAutores();
    Optional<Autor> obtenerAutorxId(Integer id);
}
