public class CartaoDeCredito {
    private Cliente cliente;
    private double limiteDeCredito;
    private double saldo;

    public CartaoDeCredito(double limiteDeCredito) {
        this.cliente = cliente;
        this.limiteDeCredito = limiteDeCredito;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean fazerCompra(double valor) {
        if (saldo + valor <= limiteDeCredito) {
            saldo += valor;
        } else {
            System.out.println("Limite de crédito excedido.");
        }
        return false;
    }

    public String getLimite() {

        return null;
    }

    public String getFatura() {
        return null;
    }

    public boolean comprar(double valor) {
        return false;
    }
}
