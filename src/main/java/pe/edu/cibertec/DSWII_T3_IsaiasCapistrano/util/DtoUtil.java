package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd.Publicacion;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.dto.DtoEntity;
import pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.dto.PublicacionDto;

@Component
public class DtoUtil {


    public DtoEntity convertirADto(Object obj, DtoEntity mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }
    public Object convertirDtoAEntity(Object obj, DtoEntity mapper){
        return new ModelMapper().map(mapper, obj.getClass());
    }

    public PublicacionDto convertirADto(Publicacion publicacion, PublicacionDto dto) {
        return new ModelMapper().map(publicacion, dto.getClass());
    }


}
