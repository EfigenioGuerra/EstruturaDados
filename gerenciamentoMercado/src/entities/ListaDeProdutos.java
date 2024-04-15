package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ListaDeProdutos {

    public static Scanner sc = new Scanner(System.in);

    private static List<Produto> listaProdutos = new ArrayList<>();

    public static List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        ListaDeProdutos.listaProdutos = listaProdutos;
    }

    private static int proximoCodigo = 1;

    public ListaDeProdutos() {
    }

    public static int gerarCodigoProduto() {
        return proximoCodigo++;
    }

    public static void cadastrarProdutos() {
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        while (nome.isEmpty()) {
            System.out.println("Digite um nome válido:");
            nome = sc.nextLine();
        }
        BigDecimal valor = null;
        try {
            System.out.println("Digite o preço do produto:");
            valor = sc.nextBigDecimal();
            sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("O Valor não pode estar vazio");
        }
        int codigo = gerarCodigoProduto();
        Produto produto = new Produto(nome, codigo, "Ativo", 0, valor);
        ListaDeProdutos.getListaProdutos().add(produto);
    }

    public static void apresentarProduto() {
        if (ListaDeProdutos.getListaProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado!\n");
        } else {
            for (Produto listaProduto : ListaDeProdutos.getListaProdutos()) {
                System.out.println(listaProduto);
            }
        }
    }

    public static Produto encontraProdutos() {
        System.out.println("Digite o código do produto que deseja alterar a situção:");
        int codigoProduto = sc.nextInt();
        Produto produto = ListaDeProdutos.getListaProdutos().stream().filter((produto1 -> produto1.getCodigo() == codigoProduto)).findFirst().orElse(null);
        if (produto == null) {
            System.out.println("Digite o código de um produto existente!");
        }
        return produto;
    }

    public static Produto encontraNomeProdutos(){
        System.out.println("Digite o nome do produto que deseja encontrar:");
        String nomeProduto = sc.nextLine();
        Produto produto = ListaDeProdutos.getListaProdutos().stream().filter((produto1 -> nomeProduto.equals(produto1.getNome()))).findFirst().orElse(null);
        if (produto == null) {
            System.out.println("Nenhum produto com esse nome foi encontrado!");
        }
        return produto;
    }

    public static void removeProduto(){
        Produto produto = ListaDeProdutos.encontraProdutos();
        ListaDeProdutos.getListaProdutos().remove(produto);
        System.out.println("Produto removido com sucesso!");
    }
}
