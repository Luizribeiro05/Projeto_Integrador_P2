package app;

import Entidades.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Conta> contas = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    acessarConta();
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Criar nova conta");
        System.out.println("2. Acessar conta");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarConta() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o nome do titular: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o CPF do titular: ");
        String cpf = scanner.nextLine();

        Conta conta = new Conta(numeroConta, nome, saldoInicial, cpf);
        contas.add(conta);
        System.out.println("Conta criada com sucesso!");
    }

    private static void acessarConta() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            menuConta(conta);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    private static void menuConta(Conta conta) {
        int opcao;
        do {
            exibirMenuConta(conta);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    System.out.println("Saque realizado com sucesso!");
                    break;
                case 3:
                    conta.rendimentoPoupanca();
                    System.out.println("Rendimento da poupança aplicado!");
                    break;
                case 4:
                    conta.rendimentoInvestimento();
                    System.out.println("Rendimento do investimento aplicado!");
                    break;
                case 5:
                    System.out.print("Digite o número da conta de destino: ");
                    int numeroContaDestino = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Digite o valor a transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    Conta contaDestino = buscarConta(numeroContaDestino);
                    if (contaDestino != null) {
                        conta.transferir(contaDestino, valorTransferencia);
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Conta de destino não encontrada!");
                    }
                    break;
                case 6:
                    conta.extratoTransacoes();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenuConta(Conta conta) {
        System.out.println("\n--- Conta ---");
        System.out.println("Titular: " + conta.getNome());
        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.println("CPF: " + conta.getCpf());
        System.out.println("Saldo: R$" + conta.getSaldo());
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Rendimento da Poupança");
        System.out.println("4. Rendimento do Investimento");
        System.out.println("5. Transferência entre Contas");
        System.out.println("6. Extrato de Transações");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }
}