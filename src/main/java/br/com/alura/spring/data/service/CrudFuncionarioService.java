package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    private CargoRepository cargoRepository;
    private Boolean sistem = true;


    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
    }

    public void initial(Scanner scanner) {
        while (sistem) {
            System.out.println("FUNCIONARIOS");
            System.out.println("Digite qual serviço deseja realizar");
            System.out.println("0 - exit");
            System.out.println("1 - save");
            System.out.println("3 - findAll");
            System.out.println("4 - delete");
            Integer comand = scanner.nextInt();

            switch (comand) {
                case 1:
                    save(scanner);
                    break;
                case 3:
                    findAll(scanner);
                    break;
                case 4:
                    delete(scanner);
                    break;
                default:
                    sistem = false;
            }
        }
    }

    private void save(Scanner scanner) {
        System.out.println("digite o nome do funcionario");
        Funcionario funcionario = new Funcionario();
        String name = scanner.next();
        funcionario.setName(name);
        System.out.println("digite o cpf");
        String cpfScanner = scanner.next();
        funcionario.setCpf(cpfScanner);
        System.out.println("digite o salario");
        Double salario = scanner.nextDouble();
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(LocalDate.now());
        System.out.println("digite o id do cargo");
        Integer cargoId = scanner.nextInt();
        Cargo cargo = this.cargoRepository.findById(cargoId).get();
        funcionario.setCargo(cargo);

        this.funcionarioRepository.save(funcionario);
        System.out.println("save!!");
    }

    private void findAll(Scanner scanner) {
        System.out.println("Qual pagina você deseja visualizar");
        Integer page = scanner.nextInt();
        Pageable pageable = PageRequest.of(page, 2, Sort.by(Sort.Direction.ASC, "name"));
        Page<Funcionario> funcionarios = this.funcionarioRepository.findAll(pageable);
        System.out.println(funcionarios.toString());
        System.out.println("Pagina atual " + funcionarios.getTotalPages());
        System.out.println("total elementos " + funcionarios.getTotalElements());
        funcionarios.stream().forEach(System.out::println);
        System.out.println("lista finalizada volte sempre.");
    }
    private void delete(Scanner scanner) {
        System.out.println("informe o id to delete");
        Integer id = scanner.nextInt();
        this.funcionarioRepository.deleteById(id);
        System.out.println("deletedo com sucesso!");

    }

}
