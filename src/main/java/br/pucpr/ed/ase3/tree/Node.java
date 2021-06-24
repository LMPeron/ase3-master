package br.pucpr.ed.ase3.tree;

public class Node<T> {
    protected T dados;
    protected Node filhoEsquerdo;
    protected Node filhoDireito;

    public Node(T dados) {
        this.dados = dados;
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public Node getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(Node filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public Node getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(Node filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    protected int getQuantidadeFilhos(){
        int quantidadeFilhos = 0;
        if(filhoEsquerdo != null){
            quantidadeFilhos++;
        }
        if(filhoDireito != null){
            quantidadeFilhos++;
        }
        return quantidadeFilhos;
    }

    @Override
    public String toString() {
        return "Node{" +
            "dados=" + dados +
            '}';
    }
}
