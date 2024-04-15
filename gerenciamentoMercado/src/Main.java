import entities.ListaDeProdutos;
import entities.ApresentacaoDosProdutos;
import entities.ListaTelefonica;
import entities.Produto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListaDeProdutos listaDeProdutos = new ListaDeProdutos();

        int opcao;

        do {
            System.out.println("\nDigite qual ação deseja realizar: " +
                    "\n1 - Visualizar produtos" +
                    "\n2 - Cadastrar produtos" +
                    "\n3 - Ativar/Inativar produtos" +
                    "\n4 - Adicionar estoque" +
                    "\n5 - Retirar estoque" +
                    "\n6 - Opções de ordenação dos produtos" +
                    "\n7 - Remover produto" +
                    "\n8 - Comprar produto" +
                    "\n9 - Gerenciar Lista Telefônica" +
                    "\n10 - Fechar aplicação");
            System.out.println("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    ListaDeProdutos.apresentarProduto();
                    break;
                case 2:
                    ListaDeProdutos.cadastrarProdutos();
                    break;
                case 3:
                    Produto.ativarInativarProduto();
                    break;
                case 4:
                    Produto.adicionarEstoque();
                    break;
                case 5:
                    Produto.removerEstoque();
                    break;
                case 6:
                    ApresentacaoDosProdutos.imprimirMenu();
                    int opcaoMenu = sc.nextInt();
                    switch (opcaoMenu) {
                        case 1:
                            ApresentacaoDosProdutos.ordemCrescenteCodigo(ApresentacaoDosProdutos.getCloneLista());
                            break;
                        case 2:
                            ApresentacaoDosProdutos.ordemAlfabetica(ApresentacaoDosProdutos.getCloneLista());
                            break;
                        case 3:
                            ApresentacaoDosProdutos.ordemEstoqueMaior(ApresentacaoDosProdutos.getCloneLista());
                            break;
                        case 4:
                            ApresentacaoDosProdutos.ordemEstoqueMenor(ApresentacaoDosProdutos.getCloneLista());
                            break;
                        case 5:
                            ApresentacaoDosProdutos.somenteAtivos(ListaDeProdutos.getListaProdutos());
                            break;
                        case 6:
                            ApresentacaoDosProdutos.somenteInativos(ListaDeProdutos.getListaProdutos());
                            break;
                        case 7:
                            ApresentacaoDosProdutos.comEstoque(ListaDeProdutos.getListaProdutos());
                            break;
                        case 8:
                            ApresentacaoDosProdutos.semEstoque(ListaDeProdutos.getListaProdutos());
                            break;
                        case 9:
                            ApresentacaoDosProdutos.apresentarPorNome(ListaDeProdutos.getListaProdutos());
                            break;
                        case 10:
                            ApresentacaoDosProdutos.ordemDataCrescente(ApresentacaoDosProdutos.getCloneLista());
                            break;
                        case 11:
                            ApresentacaoDosProdutos.ordemDataDecrescente(ApresentacaoDosProdutos.getCloneLista());
                            break;
                        case 12:
                            ApresentacaoDosProdutos.ordemPrecoCrescente(ApresentacaoDosProdutos.getCloneLista());
                            break;
                        case 13:
                            ApresentacaoDosProdutos.ordemPrecoDecrescente(ApresentacaoDosProdutos.getCloneLista());
                            break;
                    }
                    break;
                case 7:
                    ListaDeProdutos.removeProduto();
                    break;
                case 8:
                    Produto.comprarProduto();
                    break;
                case 9:
                    ListaTelefonica.gerenciarListaTelefonica(sc);
                    break;
            }
        } while (opcao != 10);
    }
}