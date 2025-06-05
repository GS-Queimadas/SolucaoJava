package br.com.fiap.VIAF.DomainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "SM_CLASSES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classe {

    @Id
    @Column(name = "ID_CLASSE", length = 2)
    private String id;

    @Column(name = "DESCRICAO", length = 200)
    private String descricao;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Incendio> incendios;
}
