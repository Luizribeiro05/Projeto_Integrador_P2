import java.util.Scanner;

public class Main{

public static void main(String[] args) {

    Banco banco = new Banco();
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
        System.out.println("Banco Brincs - Menu Principal");
        System.out.println("1 - Criar conta corrente");
        System.out.println("2 - Criar conta poupança");
        System.out.println("3 - Criar cartão de crédito");
        System.out.println("4 - Depositar");
        System.out.println("5 - Sacar");
        System.out.println("6 - Fazer compra com cartão de crédito");
        System.out.println("7 - Calcular juros da conta poupança");
        System.out.println("8 - Verificar saldo");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                // Criar conta corrente
                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.next();
                System.out.print("Digite o CPF do cliente: ");
                String cpf = scanner.next();
                System.out.print("Digite o número da conta: ");
                int numeroConta = scanner.nextInt();
                System.out.print("Digite o saldo inicial: ");
                double saldo = scanner.nextDouble();
                Cliente cliente = new Cliente(nome, cpf);
                banco.criarContaCorrente(cliente, numeroConta, saldo);
                System.out.println("Conta corrente criada com sucesso!");
                break;
            case 2:
                // Criar conta poupança
                System.out.print("Digite o nome do cliente: ");
                nome = scanner.next();
                System.out.print("Digite o CPF do cliente: ");
                cpf = scanner.next();
                System.out.print("Digite o número da conta: ");
                numeroConta = scanner.nextInt();
                System.out.print("Digite o saldo inicial: ");
                saldo = scanner.nextDouble();
                cliente = new Cliente(nome, cpf);
                banco.criarContaPoupanca(cliente, numeroConta, saldo);
                System.out.println("Conta poupança criada com sucesso!");
                break;
            case 3:
                // Criar cartão de crédito
                System.out.print("Digite o nome do cliente: ");
                nome = scanner.next();
                System.out.print("Digite o CPF do cliente: ");
                cpf = scanner.next();
                System.out.print("Digite o limite de crédito: ");
                double limiteDeCredito = scanner.nextDouble();
                cliente = new Cliente(nome, cpf);
                banco.criarCartaoDeCredito(cliente, limiteDeCredito, 0.0);
                System.out.println("Cartão de crédito criado com sucesso!");
                break;
            case 4:
                // Depositar
                System.out.print("Digite o número da conta: ");
                numeroConta = scanner.nextInt();
                System.out.print("Digite o valor a ser depositado: ");
                double valor = scanner.nextDouble();
                ContaCorrente contaCorrente = banco.getContaCorrente(numeroConta);
                if (contaCorrente != null) {
                    contaCorrente.depositar(valor);
                    System.out.println("Depósito realizado com sucesso!");
                } else {
                    System.out.println("Conta corrente não encontrada.");
                }
                break;
            case 5:
                // Sacar
                System.out.print("Digite o número da conta: ");
                numeroConta = scanner.nextInt();
                System.out.print("Digite o valor a ser sacado: ");
                valor = scanner.nextDouble();
                contaCorrente = banco.getContaCorrente(numeroConta
                );
                if (contaCorrente != null) {
                    if (contaCorrente.sacar(valor)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                } else {
                    System.out.println("Conta corrente não encontrada.");
                }
                break;
            case 6:
// Fazer compra com cartão de crédito
                System.out.print("Digite o número do cartão de crédito: ");
                int numeroCartao = scanner.nextInt();
                System.out.print("Digite o valor da compra: ");
                valor = scanner.nextDouble();
                CartaoDeCredito cartaoDeCredito = banco.getCartaoDeCredito(numeroCartao);
                if (cartaoDeCredito != null) {
                    if (cartaoDeCredito.comprar(valor)) {
                        System.out.println("Compra realizada com sucesso!");
                    } else {
                        System.out.println("Limite de crédito insuficiente.");
                    }
                } else {
                    System.out.println("Cartão de crédito não encontrado.");
                }
                break;
            case 7:
// Calcular juros da conta poupança
                System.out.print("Digite o número da conta poupança: ");
                numeroConta = scanner.nextInt();
                ContaPoupanca contaPoupanca = banco.getContaPoupanca(numeroConta);
                if (contaPoupanca != null) {
                    System.out.println("O saldo com juros é: " + contaPoupanca.calcularJuros());
                } else {
                    System.out.println("Conta poupança não encontrada.");
                }
                break;
            case 8:
// Verificar saldo
                System.out.print("Digite o número da conta: ");
                numeroConta = scanner.nextInt();
                Conta conta = banco.getConta(numeroConta);
                if (conta != null) {
                    System.out.println("O saldo é: " + conta.getSaldo());
                } else {
                    System.out.println("Conta não encontrada.");
                }
                break;
            case 0:
// Sair
                System.out.println("Obrigado por utilizar o Banco XYZ!");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        System.out.println();
    } while (opcao != 0);

    scanner.close();
}
}
