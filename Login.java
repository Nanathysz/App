package br.com.fecaf.controller;

import br.com.fecaf.model.Cliente;
import br.com.fecaf.model.Conta;

import java.util.Scanner;

public class Login {


    Scanner scanner = new Scanner(System.in);

    public Conta realizarLogin (Conta referenciaContas, Cliente referenciaClientes) {

        System.out.print("Informe o CPF: ");
        long cpfUser = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Informe a Senha: ");
        String senhaUser = scanner.nextLine();

        Cliente clienteConta = referenciaClientes.pesquisarCliente(cpfUser);

        if (clienteConta != null) {
            Conta contaCliente = referenciaContas.pesquisarConta(clienteConta);

            String senhaConta = contaCliente.getPassword();

            if (senhaConta.equals(senhaUser)) {
                return contaCliente;

            } else {
                System.out.println("Senha Incorreta !");
            }


        } else {
            System.out.println("Cliente não Cadastrado ! ");
        }

        return null;
    }


}