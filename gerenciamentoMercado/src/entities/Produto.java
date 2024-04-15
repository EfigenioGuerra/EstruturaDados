package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Produto {

    public String nome;
    public int codigo;
    public String situacao;
    public int estoque;
    public BigDecimal valor;
    public Date dataCadastroProduto;


//    public Produto(String nome, int codigo, String situacao, int estoque) {
//        this.nome = nome;
//        this.codigo = codigo;
//        this.situacao = situacao;
//        this.estoque = estoque;
//        this.dataCadastroProduto = new Date();
//    }


    public Produto(String nome, int codigo, String situacao, int estoque, BigDecimal valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.situacao = situacao;
        this.estoque = estoque;
        this.valor = valor;
        this.dataCadastroProduto = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataCadastroProduto() {
        return dataCadastroProduto;
    }

    public void setDataCadastroProduto(Date dataCadastroProduto) {
        this.dataCadastroProduto = dataCadastroProduto;
    }

    public int addEstoque(int valor){
        return estoque = estoque + valor;
    }

    public int removeEstoque(int valor) {
        return estoque = estoque - valor;
    }

    @Override
    public String toString() {
        return "\nProduto: " + nome +
                "\nCódigo: " + codigo +
                "\nSituacao: " + situacao +
                "\nEstoque: " + estoque +
                "\nPreço: R$ " + valor +
                "\nData: " + dataCadastroProduto;
    }

    public static Scanner sc = new Scanner(System.in);

    public static void ativarInativarProduto(){;
        Produto produto = ListaDeProdutos.encontraProdutos();
        System.out.println("Deseja ativar(1) ou inativar(2) o produto?");
        int ativarInativar = sc.nextInt();
            if (ativarInativar == 1){
                produto.situacao = "Ativo";
            } else if (ativarInativar == 2) {
                produto.situacao = "Inativo";
            }
    }

    public static void adicionarEstoque(){
        Produto produto = ListaDeProdutos.encontraProdutos();
        System.out.println("Digite a quantidade a ser adicionada: ");
        int valor = sc.nextInt();
        produto.estoque = produto.addEstoque(valor);
    }

    public static void removerEstoque(){
        Produto produto = ListaDeProdutos.encontraProdutos();
            System.out.println("Digite a quantidade a ser retirada: ");
            int valor = sc.nextInt();
            produto.estoque = produto.removeEstoque(valor);
        }


    public static void comprarProduto() {
        Scanner sc = new Scanner(System.in);
        Produto produto = ListaDeProdutos.encontraProdutos();
        System.out.println("Digite a quantidade desejada:");
        int qnt = sc.nextInt();
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        if (produto.getEstoque() < qnt) {
            System.out.println("Estoque insuficiente para a quantidade desejada.");
            return;
        }
        produto.removeEstoque(qnt);
        BigDecimal total = produto.getValor().multiply(BigDecimal.valueOf(qnt));
        System.out.println("Compra realizada com sucesso:");
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Quantidade: " + qnt);
        System.out.println("Total: R$ " + total);
    }
    }


