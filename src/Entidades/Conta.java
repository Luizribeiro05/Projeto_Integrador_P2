package Entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int numeroConta;
    private String nome;
    private double saldo;
    private String cpf;
    private List<String> transacoes;

    public Conta(int numeroConta, String nome, double saldo, String cpf) {
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldo = saldo;
        this.cpf = cpf;
        this.transacoes = new ArrayList<>();
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }

    public void depositar(double valor) {
        saldo += valor;
        registrarTransacao(LocalDateTime.now(), "Depósito", valor);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            registrarTransacao(LocalDateTime.now(), "Saque", -valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void rendimentoPoupanca() {
        double rendimento = saldo * 0.02;
        saldo += rendimento;
        registrarTransacao(LocalDateTime.now(), "Rendimento Poupança", rendimento);
    }

    public void rendimentoInvestimento() {
        double rendimento = saldo * 0.10;
        saldo += rendimento;
        registrarTransacao(LocalDateTime.now(), "Rendimento Investimento", rendimento);
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            contaDestino.depositar(valor);
            registrarTransacao(LocalDateTime.now(), "Transferência para conta " + contaDestino.getNumeroConta(), -valor);
            contaDestino.registrarTransacao(LocalDateTime.now(), "Transferência recebida da conta " + getNumeroConta(), valor);
        } else {
            System.out.println("Saldo insuficiente para a transferência!");
        }
    }

    public void extratoTransacoes() {
        System.out.println("\n--- Extrato de Transações ---");
        for (String transacao : transacoes) {
            System.out.println(transacao);
        }
    }

    private void registrarTransacao(LocalDateTime dataHora, String descricao, double valor) {
        String transacao = dataHora.toString() + " - " + descricao + ": R$" + valor;
        transacoes.add(transacao);
    }
}
