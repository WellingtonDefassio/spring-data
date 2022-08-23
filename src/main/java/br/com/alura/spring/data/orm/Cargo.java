package br.com.alura.spring.data.orm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
