package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ApresentacaoDosProdutos {

    private static List<Produto> cloneLista = new ArrayList<>(ListaDeProdutos.getListaProdutos());

    public static List<Produto> getCloneLista() {
        return cloneLista;
    }

    public static void setCloneLista(List<Produto> cloneLista) {
        ApresentacaoDosProdutos.cloneLista = cloneLista;
    }


    public static void imprimirMenu() {
        System.out.println("Escolha uma opção de impressão: " +
                "\n1 - Ordem crescente de código" +
                "\n2 - Ordem alfabética" +
                "\n3 - Ordem de quantidade de estoque maior" +
                "\n4 - Ordem de quantidade de estoque menor" +
                "\n5 - Somente ativos" +
                "\n6 - Somente inativos" +
                "\n7 - Somente com estoque" +
                "\n8 - Somente sem estoque" +
                "\n9 - Filtrando por nome" +
                "\n10 - Ordem de data de cadastro crescente" +
                "\n11 - Ordem de data de cadastro decrescente" +
                "\n12 - Preço crescente" +
                "\n13 - Preço decrescente" +
                "\nOpção: ");
    }

    public static void ordemCrescenteCodigo(List<Produto> cloneLista) {
        cloneLista.sort(Comparator.comparingInt(Produto::getCodigo));
        System.out.println("Lista ordenada em ordem crescente de código!");
        for (Produto produto : ApresentacaoDosProdutos.getCloneLista()){
            System.out.println(produto);
        }
    }

    public static void ordemAlfabetica(List<Produto> cloneLista) {
        cloneLista.sort(Comparator.comparing(Produto::getNome));
        System.out.println("Lista ordenada em ordem alfabética!");
        for (Produto produto : ApresentacaoDosProdutos.getCloneLista()){
            System.out.println(produto);
        }
    }

    public static void ordemEstoqueMaior(List<Produto> cloneLista) {
        cloneLista.sort(Comparator.comparingInt(Produto::getEstoque).reversed());
        System.out.println("Lista ordenada por quantidade de estoque maior!");
        for (Produto produto : ApresentacaoDosProdutos.getCloneLista()){
            System.out.println(produto);
        }
    }

    public static void ordemEstoqueMenor(List<Produto> cloneLista) {
        cloneLista.sort(Comparator.comparingInt(Produto::getEstoque));
        System.out.println("Lista ordenada por quantidade de estoque menor!");
        for (Produto produto : ApresentacaoDosProdutos.getCloneLista()){
            System.out.println(produto);
        }
    }

    public static void somenteAtivos(List<Produto> listaProdutos) {
        System.out.println("Produtos Ativos:");
        for (Produto produto : ListaDeProdutos.getListaProdutos()) {
            if ("Ativo".equals(produto.getSituacao())) {
                System.out.println(produto);
            }
        }
    }

    public static void somenteInativos(List<Produto> listaProdutos) {
        System.out.println("Produtos Inativos:");
        for (Produto produto : ListaDeProdutos.getListaProdutos()) {
            if ("Inativo".equals(produto.getSituacao())) {
                System.out.println(produto);
            }
        }
    }

    public static void comEstoque(List<Produto> listaProdutos) {
        System.out.println("Produtos com estoque:");
        for (Produto produto : ListaDeProdutos.getListaProdutos()) {
            if (produto.getEstoque() != 0) {
                System.out.println(produto);
            }
        }
    }

    public static void semEstoque(List<Produto> listaProdutos) {
        System.out.println("Produtos com estoque:");
        for (Produto produto : ListaDeProdutos.getListaProdutos()) {
            if (produto.getEstoque() == 0) {
                System.out.println(produto);
            }
        }
    }

    public static void apresentarPorNome(List<Produto> listaProdutos){
        Produto produto = ListaDeProdutos.encontraNomeProdutos();
        System.out.println(produto);
    }

    public static void ordemDataCrescente (List<Produto> cloneLista) {
        cloneLista.sort(Comparator.comparing(Produto::getDataCadastroProduto));
        System.out.println("Lista ordenada por data crescente de cadastro!");
        for (Produto produto : ApresentacaoDosProdutos.getCloneLista()){
            System.out.println(produto);
        }
    }

    public static void ordemDataDecrescente (List<Produto> cloneLista) {
        cloneLista.sort(Comparator.comparing(Produto::getDataCadastroProduto).reversed());
        System.out.println("Lista ordenada por data decrescente de cadastro!");
        for (Produto produto : ApresentacaoDosProdutos.getCloneLista()){
            System.out.println(produto);
        }
    }

    public static void ordemPrecoCrescente (List<Produto> cloneLista) {
        cloneLista.sort(Comparator.comparing(Produto::getValor));
        System.out.println("Lista ordenada por preço crescente!");
        for (Produto produto : ApresentacaoDosProdutos.getCloneLista()){
            System.out.println(produto);
        }
    }

    public static void ordemPrecoDecrescente (List<Produto> cloneLista) {
        cloneLista.sort(Comparator.comparing(Produto::getValor).reversed());
        System.out.println("Lista ordenada por preço decrescente!");
        for (Produto produto : ApresentacaoDosProdutos.getCloneLista()){
            System.out.println(produto);
        }
    }

}



