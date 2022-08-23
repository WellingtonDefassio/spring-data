package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Unidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Integer> {
}
