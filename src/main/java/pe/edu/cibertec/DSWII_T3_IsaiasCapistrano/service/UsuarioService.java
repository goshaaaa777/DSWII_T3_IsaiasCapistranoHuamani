package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Usuario;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.repository.UsuarioRepository;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
}
