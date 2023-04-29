public class ContaPoupanca {
    private Cliente cliente;
    private int numeroConta;
    private double saldo;
    private double taxaDeJuros = 0.005;

    public ContaPoupanca(int numeroConta) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public Object calcularJuros() {
        saldo += saldo * taxaDeJuros;
        return 0;
    }

    public double calcularJuros(int meses) {
        return 0;
    }
}
