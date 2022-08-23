package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {
    private CargoRepository cargoRepository;
    private Boolean sistem = true;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void initial(Scanner scanner) {
        while (sistem) {
            System.out.println("CARGOS");
            System.out.println("Digite qual serviço deseja realizar");
            System.out.println("0 - exit");
            System.out.println("1 - save");
            System.out.println("2 - update");
            System.out.println("3 - findAll");
            System.out.println("4 - delete");
            Integer comand = scanner.nextInt();

            switch (comand) {
                case 1:
                    save(scanner);
                    break;
                case 2:
                    update(scanner);
                    break;
                case 3:
                    findAll();
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
        System.out.println("Descricao do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescription(descricao);
        cargoRepository.save(cargo);
        System.out.println("save!!");
    }

    private void update(Scanner scanner) {
        System.out.println("Id do cargo");
        Integer id = scanner.nextInt();
        System.out.println("Nova descricao");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescription(descricao);
        this.cargoRepository.save(cargo);
        System.out.println("Atualizado");


    }

    private void findAll() {
        this.cargoRepository.findAll().forEach(System.out::println);

        System.out.println("lista finalizada volte sempre.");
    }

    private void delete(Scanner scanner) {
        System.out.println("informe o id to delete");
        Integer id = scanner.nextInt();
        this.cargoRepository.deleteById(id);
        System.out.println("deletedo com sucesso!");

    }

}
