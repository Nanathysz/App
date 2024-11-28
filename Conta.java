package br.com.fecaf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {
    private int numeroConta;
    private String agencia = "2808-XX";
    String password, confirmPassword;
    private double saldo = 0;
    private Cliente cliente;

    List<Conta> listContas = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void criarConta(Cliente cliente) {
        System.out.println("/-------------   Criar Conta  --------------/");
        numeroConta = (int) (Math.random()*10000);
        System.out.print("Informe uma Senha: ");
        password = scanner.nextLine();

        do {
            System.out.print("Confirme a Senha: ");
            confirmPassword = scanner.nextLine();

        } while (!password.equals(confirmPassword));

        this.cliente = cliente;
        System.out.println("/--------------------------------------------/");
    }

    public void exibirPerfil() {
        System.out.println("|---------------------------------------------|");
        System.out.println("| Olá " + cliente.getNome());
        System.out.println("| Agência: " + agencia);
        System.out.println("| Conta: " + numeroConta);
        System.out.println("|---------------------------------------------|");
    }


    public void consultarSaldo(){
        System.out.println("/-------------------  Saldo  -----------------/");
        System.out.println("/ O saldo disponivel é: " + saldo);
        System.out.println("/---------------------------------------------/");
    }

    public void realizarDeposito(Double valorDeposito){
        saldo += valorDeposito;
    }

    public void realizarSaque(Double valorSaque) {

        if (saldo < valorSaque){
            System.out.println("Saldo Indisponivel ...");
            System.out.println("Vai te embora !");
        } else {
            saldo -= valorSaque;
        }
    }
    public boolean realizarTransferencia(double valorTransferencia) {
        if (saldo < valorTransferencia) {
            System.out.println("Saldo Indisponível ...");
            return false;
        } else {
            saldo -= valorTransferencia;
            return true;
        }
    }


    public void adicionarContaList(Conta conta) {
        listContas.add(conta);
    }

    public Conta pesquisarConta (Cliente cliente) {
        for (Conta conta : listContas) {
            if (conta.cliente == cliente) {
                return conta;
            }
        }
        System.out.println("Conta não Cadastrada !");
        return null;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}