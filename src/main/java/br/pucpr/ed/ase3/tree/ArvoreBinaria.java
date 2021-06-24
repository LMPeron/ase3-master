package br.pucpr.ed.ase3.tree;

public class ArvoreBinaria<T extends Comparable> {

    private Node<T> raiz;

    public ArvoreBinaria() {

    }

    public ArvoreBinaria(T dadosRaiz) {
        if (dadosRaiz == null) {
            throw new IllegalArgumentException("A raiz não pode nula!");
        }
        raiz = new Node<>(dadosRaiz);
    }

    public void adicionar(T dados) {
        Node<T> node = new Node<>(dados);
        raiz = adicionarRecursivamente(raiz, node);
    }

    private Node<T> adicionarRecursivamente(Node<T> noAtual, Node<T> novoNo) {
        if (noAtual == null) {
            return novoNo;
        }
        int resultado = novoNo.dados.compareTo(noAtual.dados);
        if (resultado < 0) {
            noAtual.filhoEsquerdo = adicionarRecursivamente(noAtual.filhoEsquerdo, novoNo);
        } else {
            noAtual.filhoDireito = adicionarRecursivamente(noAtual.filhoDireito, novoNo);
        }
        return noAtual;
    }

    public T buscar(T dados) {
        Node<T> noEncontrado = buscarRecursivamente(raiz, dados);
        if (noEncontrado != null) {
            return noEncontrado.dados;
        } else {
            return null;
        }
    }

    private Node<T> buscarRecursivamente(Node<T> noAtual, T dados) {
        if (noAtual == null) {
            return null;
        }
        int resultado = dados.compareTo(noAtual.dados);
        if (resultado == 0) {
            return noAtual;
        } else if (resultado < 0) {
            return buscarRecursivamente(noAtual.filhoEsquerdo, dados);
        } else {
            return buscarRecursivamente(noAtual.filhoDireito, dados);
        }
    }

    public void excluir(T dados) {
        raiz = excluirRecursivamente(raiz, dados);
    }

    private Node<T> excluirRecursivamente(Node<T> noAtual, T dados) {
        if (noAtual == null) {
            return null;
        }
        int resultado = dados.compareTo(noAtual.dados);
        if (resultado == 0) {
            switch (noAtual.getQuantidadeFilhos()) {
                case 0:
                    return null;
                case 1:
                    return noAtual.filhoEsquerdo != null ? noAtual.filhoEsquerdo
                        : noAtual.filhoDireito;
                default:
                    // Solução 1
                    adicionarRecursivamente(noAtual.filhoEsquerdo, noAtual.filhoDireito);
                    return noAtual.filhoEsquerdo;

                // Solução 2
//                    Node<T> menorNoSubArvoreDireita = buscarMenorElementoRecursivamente(
//                        noAtual.filhoDireito);
//                    noAtual.filhoDireito = excluirRecursivamente(noAtual.filhoDireito,
//                        menorNoSubArvoreDireita.dados);
//                    menorNoSubArvoreDireita.filhoEsquerdo = noAtual.filhoEsquerdo;
//                    menorNoSubArvoreDireita.filhoDireito = noAtual.filhoDireito;
//                    return menorNoSubArvoreDireita;
            }
        } else if (resultado < 0) {
            noAtual.filhoEsquerdo = excluirRecursivamente(noAtual.filhoEsquerdo, dados);
        } else {
            noAtual.filhoDireito = excluirRecursivamente(noAtual.filhoDireito, dados);
        }
        return noAtual;
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemRecursivamente(raiz);
    }

    private void percorrerEmOrdemRecursivamente(Node<T> noAtual) {
        if (noAtual == null) {
            return;
        }
        percorrerEmOrdemRecursivamente(noAtual.filhoEsquerdo);
        System.out.print(noAtual.dados + " -> ");
        percorrerEmOrdemRecursivamente(noAtual.filhoDireito);
    }

    public void percorrerPreOrdem() {

    }

    public void percorrerPosOrdem() {

    }

    public T buscarMenorElemento() {
        Node<T> menorElemento = buscarMenorElementoRecursivamente(raiz);
        if (menorElemento == null) {
            return null;
        } else {
            return menorElemento.dados;
        }
    }

    private Node<T> buscarMenorElementoRecursivamente(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.filhoEsquerdo == null) {
            return node;
        }
        return buscarMenorElementoRecursivamente(node.filhoEsquerdo);
    }

    public Integer calcularPronfundidade() {
        if (raiz == null) {
            return null;
        }
        return Math.max(calcularProfundidade(raiz.filhoEsquerdo, 0),
            calcularProfundidade(raiz.filhoDireito, 0));
    }

    private Integer calcularProfundidade(Node<T> noAtual, Integer profundidadeAtual) {
        if (noAtual == null) {
            return profundidadeAtual;
        }
        return Math.max(
            calcularProfundidade(noAtual.filhoEsquerdo, profundidadeAtual + 1),
            calcularProfundidade(noAtual.filhoDireito, profundidadeAtual + 1)
        );
    }

    public Integer contarFolhas() {
        return contarFolhasRecursivo(raiz);
    }

    private Integer contarFolhasRecursivo(Node<T> noAtual) {
        if (noAtual == null) {
            return 0;
        }
        if (noAtual.filhoEsquerdo == null && noAtual.filhoDireito == null) {
            return 1;
        }
        return contarFolhasRecursivo(noAtual.filhoEsquerdo) + contarFolhasRecursivo(
            noAtual.filhoDireito);
    }

    public Node<T> getRaiz() {
        return raiz;
    }
}

