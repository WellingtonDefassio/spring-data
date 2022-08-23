package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioDinamico {

    private FuncionarioRepository funcionarioRepository;
    private Boolean sistem = true;

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void initial(Scanner scanner) {
        while (sistem) {
            System.out.println("RELATORIOS DINAMICOS");
            System.out.println("Digite o nome");
            String nomeString = scanner.next();

            List<Funcionario> funcionarioList
                    = this.funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.name(nomeString)));
//
//            switch (comand) {
//                case 1:
//                    funcionarioByName(scanner);
//                    break;
//                default:
//                    sistem = false;
//            }

        }

    }


}
