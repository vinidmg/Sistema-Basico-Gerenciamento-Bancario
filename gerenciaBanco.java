/**
 * Projeto Java Faculdade - Sistema Bancário simples
 * @author Vinicius
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;

class ContaBancaria {
    public String nome;
    public String sobrenome;
    public String cpf;
    public double saldo;
    
    public ContaBancaria (String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }
    
    public double consultarSaldo(){
        return saldo;
    }
    
    public void depositar(double valor){
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso");
    }
    
    public void sacar(double valor){
        if (saldo >=valor){
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque");
        }
    }
    
    public void exibirMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do  {
            System.out.println("\n-----------Menu-----------");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Encerrar sessão");
            System.out.println("Qual opção você deseja escolher: ");
            opcao = scanner.nextInt();
            
            switch(opcao){
                case 1:
                    System.out.println("Saldo: R$ " + consultarSaldo());
                    break;
                case 2:
                    System.out.println("Digite o valor do depósito");
                    double valorDeposito = scanner.nextDouble();
                    depositar(valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite o valor do saque");
                    double valorSaque = scanner.nextDouble();
                    sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    
             }
        } while (opcao != 4 );
        scanner.close();
        
    }
}



public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Seja bem-vindo ao sistema bancário");
        System.out.println("Qual é o seu nome?");
        String nome = scanner.nextLine();
        System.out.println("Qual é o seu sobrenome?");
        String sobrenome = scanner.nextLine();
        System.out.println("Qual o seu cpf?");
        String cpf = scanner.nextLine();
        
        ContaBancaria conta = new ContaBancaria(nome,sobrenome,cpf);
        
        conta.exibirMenu();
        
        System.out.println("Obrigado por usar nossos serviços!");
        scanner.close();
        
    }
}
