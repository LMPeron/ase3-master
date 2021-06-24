package br.pucpr.ed.ase3;

import br.pucpr.ed.ase3.list.List;
import br.pucpr.ed.ase3.list.ListSort;
import br.pucpr.ed.ase3.list.OrderedArrayList;
import br.pucpr.ed.ase3.list.SortableArrayList;
import br.pucpr.ed.ase3.list.UnorderedArrayList;
import br.pucpr.ed.ase3.tree.ArvoreBinaria;
import br.pucpr.ed.ase3.util.StringUtil;
import br.pucpr.ed.ase3.util.Timer;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class MainApp {
    private static final int VARIEDADE_NUMEROS = 100000;

    /**
     * @todo Implementar a execução dos algoritmos definidos no README com quantidades variadas
     * de elementos e de buscas. Exibir os resultados conforme especificações.
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        Random random = new Random();

        for(int quantidadeNumeros = 10000; quantidadeNumeros <= 30000; quantidadeNumeros = quantidadeNumeros + 10000) {
            for (int quantidadeBuscas = 10000; quantidadeBuscas <= 110000; quantidadeBuscas = quantidadeBuscas + 25000) {
                System.out.println("QUANTIDADE NÚMEROS: " + quantidadeNumeros + "\t QUANTIDADE BUSCAS: " + quantidadeBuscas);

                int[] numerosGerados = IntStream.generate(() -> random.nextInt(VARIEDADE_NUMEROS))
                    .limit(
                        quantidadeNumeros)
                    .toArray();
                int[] numerosParaProcurar = new int[quantidadeBuscas];
                for(int i = 0; i < numerosParaProcurar.length; i++){
                    numerosParaProcurar[i] = numerosGerados[random.nextInt(quantidadeNumeros)];
                }
                timer.startTimer("sequencial");
                List<Integer> numberList = alocacaoArrayNaoOrdenado(numerosGerados,
                    quantidadeNumeros);
                timer.addStop("sequencial");
                timer.addStop("sequencial");
                buscaSequencial(numberList, numerosParaProcurar);
                timer.addStop("sequencial");

                timer.startTimer("binária");
                numberList = alocacaoArrayOrdenado(numerosGerados, quantidadeNumeros);
                timer.addStop("binária");
                timer.addStop("binária");
                buscaBinaria(numberList, numerosParaProcurar);
                timer.addStop("binária");
            }
        }
    }

    private static List<Integer> alocacaoArrayNaoOrdenado(int[] numbersArray, int quantidadeNumeros) {
        List<Integer> numberList = new UnorderedArrayList(quantidadeNumeros);
        for (int i = 0; i < numbersArray.length; i++) {
            numberList.add(numbersArray[i]);
        }
        return numberList;
    }

    private static void buscaSequencial(List<Integer> numberList, int[] numbersToSearch) {
        for(int i = 0; i < numbersToSearch.length; i++){
            numberList.exists(numbersToSearch[i]);
        }
    }

    private static List<Integer> alocacaoArrayOrdenado(int[] numbersArray, int quantidadeNumeros) {
        List<Integer> numberList = new OrderedArrayList(quantidadeNumeros);
        for (int i = 0; i < numbersArray.length; i++) {
            numberList.add(numbersArray[i]);
        }
        return numberList;
    }

    private static void buscaBinaria(List<Integer> numberList, int[] numbersToSearch) {
        for(int i = 0; i < numbersToSearch.length; i++){
            numberList.exists(numbersToSearch[i]);
        }
    }
}
