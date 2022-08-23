package br.com.alura.spring.data.orm;

import javax.persistence.*;
import java.util.List;

@Entity
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String descricao;

    String endereco;

    @ManyToMany(mappedBy = "unidades", fetch = FetchType.EAGER)
    List<Funcionario> funcionarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
