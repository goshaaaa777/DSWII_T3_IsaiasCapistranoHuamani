package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.service;

import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Usuario;

public interface IUsuarioService {
    Usuario obtenerUsuarioPorNomUsuario(       String nomusuario);
}
