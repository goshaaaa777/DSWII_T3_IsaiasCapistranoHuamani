package pe.edu.cibertec.DSWII_T3_IsaiasCapistrano.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name ="autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idautor;
    @Column(name = "nomautor")
    private String nomautor;
    @Column(name = "apeautor")
    private String apeautor;
    @Column(name = "fechnacautor")
    private Date fechnacautor;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Publicacion> publicaciones;
}
