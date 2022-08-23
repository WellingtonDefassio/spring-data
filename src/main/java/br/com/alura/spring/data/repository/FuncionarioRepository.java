package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {

    List<Funcionario> findByName(String name);

    @Query("SELECT f FROM Funcionario f where f.name = :name AND f.salario >= :salary AND f.dataContratacao>= :date")
    List<Funcionario> findNameDataSalario(String name, double salary, LocalDate date);

    @Query(value = "SELECT f FROM funcionario f WHERE f.data_contratacao >= :data", nativeQuery = true)
    List<Funcionario> findDataMaior(LocalDate data);

    @Query(value = "select f.id , f.name , f.salario  from funcionario f ", nativeQuery = true)
    List<FuncionarioProjecao> findFuncionarioSalario();



}
