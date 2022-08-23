package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
    private Boolean sistem = true;
    private CrudCargoService crudCargoService;
    private CrudFuncionarioService funcionarioService;
    private RelatorioService relatorioService;

    public SpringDataApplication(CrudCargoService crudCargoService, CrudFuncionarioService funcionarioService, RelatorioService relatorioService) {
        this.crudCargoService = crudCargoService;
        this.funcionarioService = funcionarioService;
        this.relatorioService = relatorioService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (sistem) {
            System.out.println("witch action you want execute?");
            System.out.println("0 - Exit");
            System.out.println("1 - Cargo");
            System.out.println("2 - Funcionario");
            System.out.println("3 - Relatorios");
            int nextInt = scanner.nextInt();

            if (nextInt == 1) {
                this.crudCargoService.initial(scanner);
            }
            if(nextInt == 2) {
            this.funcionarioService.initial(scanner);
            } if(nextInt == 3) {
            this.relatorioService.initial(scanner);
            }
            else {
                sistem = false;
            }
        }


    }
}
