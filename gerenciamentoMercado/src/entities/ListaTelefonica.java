package entities;


import java.util.*;

public class ListaTelefonica {
    ArrayList<Contato> listaContatos = new ArrayList<>();
    LinkedList<Contato> listaEncadeadaContatos = new LinkedList<>();
    TreeSet<Contato> conjuntoContatos = new TreeSet<>(Comparator.comparing(o -> o.getNome()));

    public void adicionarContato(String nome, String numeroTelefone) {
        Contato contato = new Contato(nome, numeroTelefone);
        listaContatos.add(contato);
        listaEncadeadaContatos.add(contato);
        conjuntoContatos.add(contato);
    }

    public void removerContato(String nome) {
        Contato temp = null;
        for (Contato contato : listaContatos) {
            if (contato.getNome().equals(nome)) {
                temp = contato;
                break;
            }
        }
        if (temp != null) {
            listaContatos.remove(temp);
            listaEncadeadaContatos.remove(temp);
            conjuntoContatos.remove(temp);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : listaContatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    public void exibirContatos() {
        System.out.println("Lista de Contatos:");
        for (Contato contato : listaEncadeadaContatos) {
            System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getNumeroTelefone());
        }
    }

    public void exibirContatosLinkedListEmOrdemAlfabetica() {
        System.out.println("Lista de Contatos (LinkedList em ordem alfabética):");
        List<Contato> listaOrdenada = new ArrayList<>(listaEncadeadaContatos);
        Collections.sort(listaOrdenada, Comparator.comparing(contato -> contato.nome));
        for (Contato contato : listaOrdenada) {
            System.out.println("Nome: " + contato.nome + ", Telefone: " + contato.numeroTelefone);
        }
    }

    public static void gerenciarListaTelefonica(Scanner sc) {
        ListaTelefonica listaTelefonica = new ListaTelefonica();
        int opcao;
        do {
            System.out.println("\nDigite qual ação deseja realizar na lista telefônica: " +
                    "\n1 - Adicionar contato" +
                    "\n2 - Remover contato" +
                    "\n3 - Buscar contato" +
                    "\n4 - Exibir contatos" +
                    "\n5 - Exibir contatos ordem alfabética" +
                    "\n6 - Voltar");
            System.out.println("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String nomeContato = sc.nextLine();
                    System.out.println("Digite o número de telefone do contato:");
                    String numeroContato = sc.nextLine();
                    listaTelefonica.adicionarContato(nomeContato, numeroContato);
                    break;
                case 2:
                    System.out.println("Digite o nome do contato a ser removido:");
                    String nomeRemover = sc.nextLine();
                    listaTelefonica.removerContato(nomeRemover);
                    break;
                case 3:
                    System.out.println("Digite o nome do contato a ser buscado:");
                    String nomeBuscar = sc.nextLine();
                    Contato contatoBuscado = listaTelefonica.buscarContato(nomeBuscar);
                    if (contatoBuscado != null) {
                        System.out.println("Contato encontrado: " + contatoBuscado.getNome() + " - " + contatoBuscado.getNumeroTelefone());
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 4:
                    listaTelefonica.exibirContatos();
                    break;
                case 5:
                    listaTelefonica.exibirContatosLinkedListEmOrdemAlfabetica();
                    break;
            }
        } while (opcao != 6);
    }
}
