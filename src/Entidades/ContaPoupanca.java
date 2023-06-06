package Entidades;

public class ContaPoupanca {
    private double saldo;

    public ContaPoupanca(double saldo) {
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

    public void rendimentoPoupanca() {
        double rendimento = saldo * 0.02;
        saldo += rendimento;
    }
}
