public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionarConta(ContaCorrente contaCorrente1) {

    }

    public void adicionarCartao(CartaoDeCredito cartao1) {

    }
}