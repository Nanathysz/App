package br.com.fecaf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente  {

    private String nome;
    private long cpf;
    private long rg;
    private long telefone;
    private int idade;
    private String email;

    List<Cliente> clienteList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public boolean cadastrarCliente() {
        System.out.println("/--------------  Cadastro Cliente  ------------/");
        System.out.print("Informe o nome: ");
        nome = scanner.nextLine();
        System.out.print("Informe o CPF: ");
        cpf = scanner.nextLong();
        System.out.print("Informe o RG: ");
        rg = scanner.nextLong();
        System.out.print("Informe o telefone: ");
        telefone = scanner.nextLong();
        System.out.print("Informe a idade: ");
        idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe o email: ");
        email = scanner.nextLine();
        System.out.println("/-----------------------------------------------/");

        return true;

    }

    public void exibirInformacoes() {
        System.out.println("/-------------   Informações Cliente  ----------/");
        System.out.println("O nome do cliente é: " + nome);
        System.out.println("O CPF do cliente é: " + cpf);
        System.out.println("O RG do cliente é: " + rg);
        System.out.println("O telefone do cliente é: " + telefone);
        System.out.println("A idade do cliente é: " + idade);
        System.out.println("O email do cliente é: " + email);
        System.out.println("/----------------------------------------------- /");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void adicionarClienteList(Cliente cliente) {
        clienteList.add(cliente);
    }

    public Cliente pesquisarCliente (long cpf) {
        for (Cliente cliente : clienteList) {

            long cpfCliente = cliente.getCpf();

            if (cpf == cpfCliente) {
                return cliente;
            }
        }

        System.out.println("Usuario não encontrado ! ");
        return null;
    }
}