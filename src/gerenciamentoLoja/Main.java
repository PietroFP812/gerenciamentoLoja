package gerenciamentoLoja;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar produto");
            System.out.println("3 - Iniciar venda");
            System.out.println("4 - Adicionar produto ao carrinho");
            System.out.println("5 - Exibir conteúdo do carrinho");
            System.out.println("6 - Fechar venda");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    BigInteger cpf = scanner.nextBigInteger();
                    loja.cadastrarCliente(new Cliente(nome, cpf));
                }
                case 2 -> {
                    System.out.print("Código do produto: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Valor do produto: ");
                    double valor = scanner.nextDouble();
                    loja.cadastrarProduto(new Produto(codigo, valor));
                }
                case 3 -> {
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    if (!loja.iniciarVenda(nomeCliente)) {
                        System.out.println("Cliente não encontrado!");
                    }
                }
                case 4 -> {
                    System.out.print("Código do produto: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();
                    System.out.print("Desconto (%): ");
                    double desconto = scanner.nextDouble();
                    if (!loja.adicionarProduto(codigo, qtd, desconto)) {
                        System.out.println("Produto não encontrado ou venda não iniciada!");
                    }
                }
                case 6 -> System.out.println("Total da venda: " + loja.fecharVenda());
            }
        } while (opcao != 0);

        scanner.close();
    }
}