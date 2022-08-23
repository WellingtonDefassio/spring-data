package br.com.alura.spring.data.specification;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFuncionario {

    public static Specification<Funcionario> name(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Funcionario> cpf(String cpf) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
    }
    public static Specification<Funcionario> sario(Double salario) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salario"), salario);
    }



}
