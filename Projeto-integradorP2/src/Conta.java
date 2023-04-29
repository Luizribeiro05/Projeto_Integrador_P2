public abstract class Conta {
    private Cliente cliente;
    private int numeroConta;
    private double saldo;

    public Conta(Cliente cliente, int numeroConta, double saldo) {
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

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}
