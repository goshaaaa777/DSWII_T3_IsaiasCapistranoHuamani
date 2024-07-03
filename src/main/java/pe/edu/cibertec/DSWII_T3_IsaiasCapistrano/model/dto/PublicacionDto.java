package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PublicacionDto implements DtoEntity {
    private String titulo;
    private String resumen;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date fecha;
    private String nomautor;
    private String apeautor;
}