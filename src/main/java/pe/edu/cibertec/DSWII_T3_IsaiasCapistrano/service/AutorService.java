package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Autor;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AutorService implements IAutorService {

    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarAutores() {
        return autorRepository.findAll();

    }
    @Override
    public Optional<Autor> obtenerAutorxId(Integer id) {
        return autorRepository.findById(id);
    }
}
