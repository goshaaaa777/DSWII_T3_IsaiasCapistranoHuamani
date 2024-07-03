package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Publicacion;

import java.util.List;

@Data
public class AutorDto implements DtoEntity{
    @JsonProperty("ID del Autor")
    private Integer idautor;
    @JsonProperty("Nombres")
    private String nomautor;
    @JsonProperty("Apellidos")
    private String apeautor;
    @JsonProperty("Publicaciones")
    private List<Publicacion> publicaciones;

}
