package br.com.fecaf.controller;

import br.com.fecaf.model.Cliente;
import br.com.fecaf.model.Conta;

import java.util.Random;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    Conta contaAtual = new Conta();
    Cliente clienteAtual = new Cliente();


    public void mostrarMenu() {

        boolean sair = false;

        while(!sair) {
            System.out.println("/------------------------------------/");
            System.out.println("/------------ Banco FECAF -----------/");
            System.out.println("/------------------------------------/");
            System.out.println("/ 1 - Login                          /");
            System.out.println("/ 2 - Criar Conta                    /");
            System.out.println("/ 3 - Sair                           /");
            System.out.println("/------------------------------------/");

            System.out.print("Escolha uma opção: ");
            int opcaoUsuario = sc.nextInt();
            sc.nextLine();

            switch (opcaoUsuario){
                case 1:
                    Login login = new Login();
                    Conta contaCliente = login.realizarLogin(contaAtual, clienteAtual);

                    if (contaCliente != null){
                        acessarConta(contaCliente);
                    }

                    break;
                case 2:

                    Cliente novoCliente = new Cliente();
                    novoCliente.cadastrarCliente();
                    novoCliente.exibirInformacoes();

                    Conta novaConta = new Conta();
                    novaConta.criarConta(novoCliente);
                    novaConta.exibirPerfil();

                    clienteAtual.adicionarClienteList(novoCliente);
                    contaAtual.adicionarContaList(novaConta);

                    break;

                case 3:
                    System.out.println("Saindo...");
                    sair = true;
                    break;

                default:
                    System.out.println("Escolha uma opção válida !");
                    sugerirOfertas();
            }
        }

    }

    public void acessarConta(Conta conta) {

        boolean sairConta = false;

        while (!sairConta) {
            conta.exibirPerfil();

            System.out.println("/---------------------------------------/");
            System.out.println("/------------  Menu da Conta -----------/");
            System.out.println("/---------------------------------------/");
            System.out.println("/ 1 - Consultar Saldo                   /");
            System.out.println("/ 2 - Realizar Depósito                 /");
            System.out.println("/ 3 - Realizar Saque                    /");
            System.out.println("/ 4 - Realizar Transferência            /");
            System.out.println("/ 5 - Sair                              /");
            System.out.println("/---------------------------------------/");

            int opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu) {
                case 1:
                    conta.consultarSaldo();
                    sugerirOfertas();
                    break;

                case 2:
                    System.out.println("/------- Depósito ---------/");
                    System.out.print("Informe o valor para depósito: ");
                    double valorDeposito = sc.nextDouble();
                    sc.nextLine();

                    conta.realizarDeposito(valorDeposito);
                    conta.consultarSaldo();
                    sugerirOfertas();

                    break;

                case 3:
                    System.out.println("/------- Saque ---------/");
                    System.out.print("Informe o valor para saque: ");
                    double valorSaque = sc.nextDouble();
                    sc.nextLine();

                    conta.realizarSaque(valorSaque);
                    conta.consultarSaldo();
                    sugerirOfertas();
                    break;

                case 4:
                    System.out.println("/------- Transferência ---------/");
                    System.out.print("Informe o CPF do destinatário: ");
                    long cpf = sc.nextLong();

                    System.out.print("Informe o valor de transferência: ");
                    double valorTransferencia = sc.nextDouble();

                    Cliente clienteTransferencia = clienteAtual.pesquisarCliente(cpf);

                    if (clienteTransferencia != null) {

                        Conta contaDestino = contaAtual.pesquisarConta(clienteTransferencia);

                        if (contaDestino != null) {

                            if (conta.realizarTransferencia(valorTransferencia)) {
                                contaDestino.realizarDeposito(valorTransferencia);
                                System.out.println("Transferência realizada!");
                            } else {
                                System.out.println("Saldo insuficiente para realizar a transferência.");
                            }
                        } else {
                            System.out.println("Conta do destinatário não encontrada.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    conta.consultarSaldo();
                    sugerirOfertas();
                    break;

                case 5:
                    sairConta = true;
                    break;

                default:
                    System.out.println("Escolha uma opção válida!");
                    sugerirOfertas();
            }
        }

    }

    public void sugerirOfertas(){
        Random random = new Random();
        int sugestao = random.nextInt(4);

        switch (sugestao) {
            case 1:
                System.out.println("Oferecemos as melhores taxas do mercado!");
                break;

            case 2:
                System.out.println("Investir é o caminho para o sucesso!");
                break;

            case 3:
                System.out.println("O banco FECAF é conhecido pela sua confiança!");
                break;

            default:
                System.out.println("Aproveite serviços exclusivos e personalizados!");
        }
    }

}
