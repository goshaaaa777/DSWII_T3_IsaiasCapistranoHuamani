package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Publicacion;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.repository.PublicacionRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class PublicacionService implements IPublicacionService {

    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> listarPublicaciones() {
        return publicacionRepository.findAll();
    }
}
