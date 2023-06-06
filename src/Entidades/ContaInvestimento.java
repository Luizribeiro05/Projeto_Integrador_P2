package Entidades;

public class ContaInvestimento {
    private double saldo;

    public ContaInvestimento(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void rendimentoInvestimento() {
        double rendimento = saldo * 0.1;
        saldo += rendimento;
    }
}
