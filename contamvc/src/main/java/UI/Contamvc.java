package UI;

import entidade.Conta;
import fachada.Fachada;
import java.util.ArrayList;
import java.util.Scanner;

public class Contamvc {

    private static Fachada fachada = new Fachada();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        int opcao;
        do {
            System.out.println("-------------- MENU ---------------");
            System.out.println("1- Inserir Conta");
            System.out.println("2- Remover Conta");
            System.out.println("3- Alterar Conta");
            System.out.println("4- Buscar Conta");
            System.out.println("5- Relatório de todas as contas");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumindo a quebra de linha
            System.out.println(); // Nova linha para separar as operações

            switch (opcao) {
                case 1:
                    inserirConta();
                    break;
                case 2:
                    removerConta();
                    break;
                case 3:
                    alterarConta();
                    break;
                case 4:
                    buscarConta();
                    break;
                case 5:
                    relatorioContas();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void inserirConta() {
        try {
            System.out.print("Número da Conta: ");
            int numeroConta = scanner.nextInt();
            scanner.nextLine(); // Consumindo a quebra de linha
            System.out.print("Titular da Conta: ");
            String titular = scanner.nextLine();
            System.out.print("Deseja fazer um depósito inicial (s/n): ");
            char dc = scanner.nextLine().charAt(0);
            double saldo = 0;
            if (dc == 's') {
                System.out.print("Insira o valor inicial: R$ ");
                saldo = scanner.nextDouble();
            }
            Conta conta = new Conta(numeroConta, titular, saldo);
            fachada.inserirConta(conta);
            System.out.println("Conta inserida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir conta: " + e.getMessage());
        }
    }

    private static void removerConta() {
        try {
            System.out.print("Número da Conta a ser removida: ");
            int numeroConta = scanner.nextInt();
            fachada.removerConta(numeroConta);
            System.out.println("Conta removida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover conta: " + e.getMessage());
        }
    }

    private static void alterarConta() {
        try {
            System.out.print("Número da Conta a ser alterada: ");
            int numeroConta = scanner.nextInt();
            scanner.nextLine(); // Consumindo a quebra de linha
            System.out.print("Novo titular da Conta: ");
            String novoTitular = scanner.nextLine();
            Conta conta = new Conta(numeroConta, novoTitular, 0);
            fachada.alterarConta(conta);
            System.out.println("Conta alterada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao alterar conta: " + e.getMessage());
        }
    }

    private static void buscarConta() {
        try {
            System.out.print("Número da Conta a ser buscada: ");
            int numeroConta = scanner.nextInt();
            Conta conta = fachada.buscarConta(numeroConta);
            if (conta != null) {
                System.out.println("Titular: " + conta.getTitular());
                System.out.println("Saldo: R$ " + conta.getSaldo());
            } else {
                System.out.println("Conta não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar conta: " + e.getMessage());
        }
    }

    private static void relatorioContas() {
        try {
            ArrayList<Conta> contas = fachada.buscarTodas();
            if (!contas.isEmpty()) {
                System.out.println("Relatório de todas as contas:");
                for (Conta conta : contas) {
                    System.out.println("Número da Conta: " + conta.getNumero());
                    System.out.println("Titular: " + conta.getTitular());
                    System.out.println("Saldo: R$ " + conta.getSaldo());
                    System.out.println("---------------------------------");
                }
            } else {
                System.out.println("Não há contas cadastradas.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerar relatório de contas: " + e.getMessage());
        }
    }
}
