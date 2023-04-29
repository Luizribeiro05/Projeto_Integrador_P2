import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaCorrente> contasCorrente = new ArrayList<>();
    private ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<>();
    private ArrayList<CartaoDeCredito> cartoesDeCredito = new ArrayList<>();

    public void criarContaCorrente(Cliente cliente, int numeroConta, double saldo) {
        ContaCorrente novaContaCorrente = new ContaCorrente(numeroConta);
        contasCorrente.add(novaContaCorrente);
    }

    public void criarContaPoupanca(Cliente cliente, int numeroConta, double saldo) {
        ContaPoupanca novaContaPoupanca = new ContaPoupanca(numeroConta);
        contasPoupanca.add(novaContaPoupanca);
    }

    public void criarCartaoDeCredito(Cliente cliente, double limiteDeCredito, double saldo) {
        CartaoDeCredito novoCartaoDeCredito = new CartaoDeCredito(limiteDeCredito);
        cartoesDeCredito.add(novoCartaoDeCredito);
    }

    public ArrayList<ContaCorrente> getContasCorrente() {
        return contasCorrente;
    }

    public ArrayList<ContaPoupanca> getContasPoupanca() {
        return contasPoupanca;
    }

    public ArrayList<CartaoDeCredito> getCartoesDeCredito() {
        return cartoesDeCredito;
    }

    public void setContasCorrente(ArrayList<ContaCorrente> contasCorrente) {
        this.contasCorrente = contasCorrente;
    }

    public void setContasPoupanca(ArrayList<ContaPoupanca> contasPoupanca) {
        this.contasPoupanca = contasPoupanca;
    }

    public void setCartoesDeCredito(ArrayList<CartaoDeCredito> cartoesDeCredito) {
        this.cartoesDeCredito = cartoesDeCredito;
    }

    public ContaCorrente getContaCorrente(int numeroConta) {
        return null;
    }

    public CartaoDeCredito getCartaoDeCredito(int numeroCartao) {
        return null;
    }

    public ContaPoupanca getContaPoupanca(int numeroContaPoupanca) {
        return null;
    }

    public Conta getConta(int numeroConta) {
        return null;
    }
}
