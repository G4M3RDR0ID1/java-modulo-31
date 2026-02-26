import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = List.of(
                new Funcionario("Carlos", 25, 3200.00),
                new Funcionario("Ana", 19, 1800.00),
                new Funcionario("Bruno", 34, 4500.50),
                new Funcionario("Mariana", 42, 6100.75),
                new Funcionario("Lucas", 23, 2800.00),
                new Funcionario("Fernanda", 55, 7200.90),
                new Funcionario("Ricardo", 60, 8000.00),
                new Funcionario("Juliana", 29, 3900.30),
                new Funcionario("Pedro", 18, 1500.00),
                new Funcionario("Camila", 47, 5300.40),
                new Funcionario("Rafael", 31, 4100.00),
                new Funcionario("Patricia", 38, 4800.20),
                new Funcionario("Eduardo", 45, 6700.00),
                new Funcionario("Beatriz", 27, 2600.00),
                new Funcionario("Thiago", 36, 5200.10),
                new Funcionario("Amanda", 22, 2100.00),
                new Funcionario("Daniel", 50, 7500.00),
                new Funcionario("Larissa", 33, 4300.80),
                new Funcionario("Gustavo", 41, 6000.00),
                new Funcionario("Renata", 28, 3400.50),
                new Funcionario("Felipe", 24, 2900.00),
                new Funcionario("Vanessa", 39, 5100.00),
                new Funcionario("Marcelo", 52, 7800.00),
                new Funcionario("Aline", 21, 2000.00),
                new Funcionario("Roberto", 58, 8200.00),
                new Funcionario("Paula", 44, 6400.60),
                new Funcionario("Leonardo", 30, 4000.00),
                new Funcionario("Carla", 26, 2700.00),
                new Funcionario("André", 48, 5600.00),
                new Funcionario("Simone", 35, 4700.00)
        );

        Empresa empresa = new Empresa(funcionarios);

        //Filtrar todos nascido entre 1975 e 1985
        List<Funcionario> funcionariosFiltroIdade = empresa.getFuncionarios().stream().filter(funcionario -> funcionario.getIdade() <= 51 && funcionario.getIdade() >= 41).toList();

        for (Funcionario f : funcionariosFiltroIdade){
            System.out.println(f);
        }

        System.out.println("--------------------------------------------------");
        //resultado do metodo que retorna a soma das idades pares dos funcionarios
        int totalIdadePar = somarIdadePar(empresa);
        System.out.println("Soma total das idades pares dos funcionarios: " + totalIdadePar);

        //Criar um metodo que recebe uma lista e
        //retorna os 30 maiores salarios,
        //de funcionarios que tenha menos de 25
        System.out.println("--------------------------------------------------");
        System.out.println("Funcionarios ate 25 anos mais bem pagos:");
        List<Funcionario> funcionariosBemPagos = mostrarMaioresSalarios(empresa);
        for (Funcionario f : funcionariosBemPagos){
            System.out.println(f);
        }
    }

    public static int somarIdadePar(Empresa empresa){
        return empresa.getFuncionarios().stream().filter(funcionario -> funcionario.getIdade() % 2 == 0).mapToInt(Funcionario::getIdade).sum();
    }

    public static List<Funcionario> mostrarMaioresSalarios(Empresa empresa){
        return empresa.getFuncionarios().stream().filter(funcionario -> funcionario.getIdade() <= 25).sorted(Comparator.comparing(Funcionario::getSalario).reversed()).limit(30).toList();

    }



}