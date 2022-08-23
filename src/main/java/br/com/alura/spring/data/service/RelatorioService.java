package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Boolean sistem = true;
    private FuncionarioRepository funcionarioRepository;

    public RelatorioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void initial(Scanner scanner) {
        while (sistem) {
            System.out.println("RELATORIOS");
            System.out.println("Digite qual serviço deseja realizar");
            System.out.println("0 - exit");
            System.out.println("1 - busca funcionario nome");
            System.out.println("2 - busca relatorio nome salario data");
            System.out.println("3 - funcionario salario");
            Integer comand = scanner.nextInt();

            switch (comand) {
                case 1:
                    funcionarioByName(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioData(scanner);
                case 3:
                    funcionarioSalario();
                default:
                    sistem = false;
            }

        }

    }

    private void funcionarioByName(Scanner scanner) {
        System.out.println("digite o nome do funcionario");
        String name = scanner.next();
        List<Funcionario> funcionariosByname = this.funcionarioRepository.findByName(name);

        funcionariosByname.forEach(System.out::println);

    }

    private void buscaFuncionarioNomeSalarioData(Scanner scanner) {
        System.out.println("digite o nome do funcionario");
        String name = scanner.next();

        System.out.println("digite a data da contratacao");
        String data = scanner.next();

        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("digite o slario");
        Double salario = scanner.nextDouble();

        List<Funcionario> nameDataSalario = this.funcionarioRepository.findNameDataSalario(name, salario, localDate);

        nameDataSalario.forEach(System.out::println);
    }

    private void funcionarioSalario() {
        List<FuncionarioProjecao> funcionarioSalario = this.funcionarioRepository.findFuncionarioSalario();
        funcionarioSalario.forEach(f -> System.out.println("id " + f.getId() + " name " + f.getName() + " salario " + f.getSalario()));
    }
}
