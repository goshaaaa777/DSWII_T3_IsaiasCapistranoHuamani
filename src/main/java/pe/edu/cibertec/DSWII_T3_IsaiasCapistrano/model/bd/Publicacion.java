package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("ID Publicación")
    private Integer idpublicacion;
    @Column(name = "titulo")
    @JsonProperty("Título")
    private String titulo;
    @JsonProperty("Resumen")
    @Column(name = "resumen")
    private String resumen;
    @JsonProperty("Fecha")
    @Column(name = "fechpublicacion")
    private Date fechpublicacion;
    @ManyToOne
    @JoinColumn(name = "idautor")
    @JsonBackReference
    private Autor autor;
}
