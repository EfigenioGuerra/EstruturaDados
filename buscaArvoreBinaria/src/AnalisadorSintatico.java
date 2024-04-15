import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnalisadorSintatico {
    private static class NoArvore {
        String chave;
        NoArvore esquerda;
        NoArvore direita;

        public NoArvore(String chave) {
            this.chave = chave;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private NoArvore raiz;

    public void inserir(String chave) {
        raiz = inserirRec(raiz, chave.toLowerCase());
    }

    private NoArvore inserirRec(NoArvore no, String chave) {
        if (no == null) {
            return new NoArvore(chave);
        }

        if (chave.compareTo(no.chave) < 0)
            no.esquerda = inserirRec(no.esquerda, chave);
        else if (chave.compareTo(no.chave) > 0)
            no.direita = inserirRec(no.direita, chave);

        return no;
    }

    public boolean buscar(String chave) {
        return buscarRec(raiz, chave.toLowerCase());
    }

    private boolean buscarRec(NoArvore no, String chave) {
        if (no == null)
            return false;

        if (chave.equals(no.chave))
            return true;

        return chave.compareTo(no.chave) < 0 ?
                buscarRec(no.esquerda, chave) :
                buscarRec(no.direita, chave);
    }

    public static void main(String[] args) {
        AnalisadorSintatico analisador = new AnalisadorSintatico();
        Scanner sc = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Guerra\\Desktop\\buscaArvoreBinaria\\dicionario.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                analisador.inserir(linha.trim());
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
        }

        System.out.println("Digite a palavra a ser buscada:");
        String palavra = sc.nextLine();
        if (analisador.buscar(palavra)) {
            System.out.println("A palavra '" + palavra + "' está presente no dicionário.");
        } else {
            System.out.println("A palavra '" + palavra + "' não está presente no dicionário.");
        }
    }
}
